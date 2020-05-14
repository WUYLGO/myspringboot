package com.wyl.research.util;

public class SynchronizedModel {
    public int i = 0;

    public void synchronizedTest() {
        synchronized (this.getClass()) {
            System.out.println("i" + i++);
        }
    }
}
