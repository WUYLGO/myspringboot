package com.wyl.research.designpattern.AbstractFactoryPatter;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class OracleConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("Oracle connecting...");
    }
}
