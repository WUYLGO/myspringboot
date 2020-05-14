package com.wyl.research.util;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock readLock = rwl.readLock();    //注意这个地方
    private Lock writeLock = rwl.writeLock();

    public static void main(String[] args) {
        final LockTest test = new LockTest();

        new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

        new Thread() {
            public void run() {
                test.select(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread) {
        writeLock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁" + "===写操作");
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            writeLock.unlock();
        }
    }

    public void select(Thread thread) {
//        if (readLock.tryLock()) {
//            System.out.println("获得锁成功");
//        }
        readLock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁" + "===读操作");
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            readLock.unlock();
        }
    }

}