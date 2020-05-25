package com.wyl.research.IOC;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/24
 */
public abstract class AbstractTestCase {

    public void run() {
        if (doTest()) {
            System.out.println("test success... ");
        } else {
            System.out.println("test fail...");
        }
    }

    public abstract boolean doTest();


}
