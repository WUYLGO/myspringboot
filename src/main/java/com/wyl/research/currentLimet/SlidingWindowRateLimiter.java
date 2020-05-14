package com.wyl.research.currentLimet;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
/**
* @Description: //TODO
* @Date: 2020/5/6 9:21
* @Idea: 滑动窗口限流方法,令牌桶算法,漏桶算法;
*/
public class SlidingWindowRateLimiter implements RateLimiter, Runnable {
    private final long maxVisitPerSecond;

    private static final int DEFAULT_BLOCK = 10;
    private final int block;
    private final AtomicLong[] countPerBlock;

    private AtomicLong count;
    private volatile int index;

    public SlidingWindowRateLimiter(int block, long maxVisitPerSecond) {
        this.block = block;
        this.maxVisitPerSecond = maxVisitPerSecond;
        countPerBlock = new AtomicLong[block];
        for (int i = 0; i < block; i++) {
            countPerBlock[i] = new AtomicLong();
        }
        count = new AtomicLong(0);
    }

    public SlidingWindowRateLimiter() {
        this(DEFAULT_BLOCK, 60);
    }

    @Override
    public boolean isOverLimit() {
        return currentQPS() > maxVisitPerSecond;
    }

    @Override
    public long currentQPS() {
        return count.get();
    }

    @Override
    public boolean visit() {
        countPerBlock[index].incrementAndGet();
        count.incrementAndGet();
        return isOverLimit();
    }

    @Override
    public void run() {
        System.out.println("是否限流===>"+isOverLimit());
        System.out.println("当前QPS===>"+currentQPS());
        System.out.println("index:" + index);
        index = (index + 1) % block;
        long val = countPerBlock[index].getAndSet(0);
        count.addAndGet(-val);
    }

    public static void main(String[] args) {
        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(10, 100);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(slidingWindowRateLimiter, 100, 100, TimeUnit.MILLISECONDS);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    slidingWindowRateLimiter.visit();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    slidingWindowRateLimiter.visit();
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }
}