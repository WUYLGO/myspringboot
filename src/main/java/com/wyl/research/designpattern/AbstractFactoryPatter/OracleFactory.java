package com.wyl.research.designpattern.AbstractFactoryPatter;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class OracleFactory implements DataBaseFactory {
    @Override
    public Connection getConnection() {
        return new OracleConnection();
    }

    @Override
    public Command getCommand() {
        return new OracleCommand();
    }
}
