package com.wyl.research.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/3
 */
public class ThreadPoolTest {


    public static void main(String[] args) {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 20, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    res.add(UUID.randomUUID().toString());
                }
            });
        }

        res.forEach(t -> {
            System.out.println(t);
        });

    }


}
