package com.wyl.research.designpattern.AbstractFactoryPatter;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class MysqlCommand implements Command {
    @Override
    public void execute() {
        System.out.println("mysql execute...");
    }
}
