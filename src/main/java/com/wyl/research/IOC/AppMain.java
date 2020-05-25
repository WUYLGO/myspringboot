package com.wyl.research.IOC;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 使用容器注册+抽象类继承/接口 来保证代码的扩展性
 * @auther: wuyunlong
 * @date: 2020/5/24
 */
public class AppMain {
    private static List<AbstractTestCase> testCases = new ArrayList<>();


    public static void registTestCase(AbstractTestCase abstractTestCase) {
        testCases.add(abstractTestCase);
    }


    static {
        registTestCase(new TestCase1());

    }


    public static void main(String[] args) {
        for (AbstractTestCase testCase : testCases) {
            testCase.run();
            testCase.doTest();
        }

    }


}
