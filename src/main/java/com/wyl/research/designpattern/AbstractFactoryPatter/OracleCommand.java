package com.wyl.research.designpattern.AbstractFactoryPatter;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class OracleCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Oracle execute...");
    }
}
