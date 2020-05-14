package com.example.demo.javaBaseTest;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/14
 */
public class Test {
    public static void main(String[] args) {
        /**
         * @Description:
         * ==>Parent的无参构造方法...
         * ==>son的有参构造方法...
         * @Date: 2020/5/14 10:55
         * @Idea: 证明调用子类的有参构造创建时首先调用的父类的无参构造方法;
         */
        Son son = new Son("aaa");



        /**
        * @Description: 多级catch异常
        * @Date: 2020/5/14 11:04
        * @Idea: 多级catch异常只会在第一级catch到的时候就结束了;
        */
        try {
            throw new RuntimeException("aaa");

        } catch (RuntimeException e) {
            System.out.println("RuntimeException==>");
        } catch (Exception e) {
            System.out.println("Exception===>");
        }


    }
}
