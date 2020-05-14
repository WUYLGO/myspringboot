package com.wyl.research.util;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/3
 */
public class LockSupportTest {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("进入子线程" + Thread.currentThread().getName());
                LockSupport.park();
                System.out.println("子线程任务结束" + Thread.currentThread().getName());
            }
        });
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程完成");

        LockSupport.unpark(thread);
        System.out.println("over.........");
    }

}
