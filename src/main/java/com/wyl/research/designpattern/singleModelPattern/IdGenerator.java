package com.wyl.research.designpattern.singleModelPattern;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static String a = "aaa";

    private IdGenerator() {
        System.out.println("bbbbbbb");
    }

    private static class SingletonHolder {
        private static final IdGenerator instance = new IdGenerator();
        private static String b = "ggg";
    }

    private static void test() {
        System.out.println("cccccccccccc");
    }

    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        IdGenerator.test();
        IdGenerator.getInstance();


    }
}