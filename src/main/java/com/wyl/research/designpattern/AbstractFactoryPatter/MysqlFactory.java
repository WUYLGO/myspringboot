package com.wyl.research.designpattern.AbstractFactoryPatter;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class MysqlFactory implements DataBaseFactory {
    @Override
    public Connection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public Command getCommand() {
        return new MysqlCommand();
    }
}
