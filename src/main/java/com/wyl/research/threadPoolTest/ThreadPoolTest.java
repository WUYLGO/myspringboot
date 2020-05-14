package com.wyl.research.threadPoolTest;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/15
 */
public class ThreadPoolTest {
    /**
     * @Description: 线程池的创建和回收
     * @Date: 2020/5/15 1:23
     * @Idea: 线程池的任务执行完成之后会根据最大空闲时间回收线程, 如果allowCoreThreadTimeOut设置为false则直到线程数刚好等于核心线程数的时候, 线程池处于等待任务执行的状态;
     * allowCoreThreadTimeOut设置为true即意味着核心线程在超时之后也可以被回收,直到没有线程存活后退出
     *
     * 线程本身也是java对象,在需要回收的时候只要将其从线程池中移除,即可以被gc回收,另外一方面可以主动调用线程的interrupt方法中断线程后进行回收;
     */

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 6, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.CallerRunsPolicy());
        executor.allowCoreThreadTimeOut(true);

        for (int i = 0; i < 15; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    String id = UUID.randomUUID().toString();
                    System.out.println("当前线程为==>" + Thread.currentThread().getName() + "   任务id为==>" + id);
                    try {
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务" + Thread.currentThread().getName() + "执行完成" + "   任务id为==>" + id);
                }
            });
            print(executor);
        }

        while (executor.getPoolSize() != 0) {
            print(executor);
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void print(ThreadPoolExecutor executor) {
        System.out.println("活跃线程数===>" + executor.getActiveCount());
        System.out.println("核心线程数===>" + executor.getCorePoolSize());
        System.out.println("线程池大小==>" + executor.getPoolSize());
        System.out.println("任务数===>" + executor.getTaskCount());
        System.out.println("已完成任务数===>" + executor.getCompletedTaskCount());
        System.out.println("队列大小===>" + executor.getQueue().size());
        System.out.println("================================================================");
    }


}
