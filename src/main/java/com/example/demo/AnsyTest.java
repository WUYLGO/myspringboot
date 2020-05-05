package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AnsyTest {

    @Async
    public Future asyncTask() {
        try {
            System.out.println(Thread.currentThread().getName() + "asyncTask子线程开始");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "===" + "asyncTask异步任务结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Future<Object> objectFuture = new AsyncResult<>("asyncTask完毕");

        return objectFuture;
    }

    @Async
    public Future asyncTask2() {
        try {
            System.out.println(Thread.currentThread().getName() + "asyncTask2子线程开始");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "===" + "asyncTask2异步任务结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Future<Object> objectFuture = new AsyncResult<>("asyncTask2完毕");

        return objectFuture;
    }


}
