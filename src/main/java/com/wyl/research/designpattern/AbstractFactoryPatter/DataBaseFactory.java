package com.wyl.research.designpattern.AbstractFactoryPatter;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public interface DataBaseFactory {


    Connection getConnection();

    Command getCommand();

}
