package com.wyl.research.designpattern.AbstractFactoryPatter;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class MainApp {

    /**
     * @Description: 抽象工厂==>创建型模式(可以理解为至少三个接口,其中一个是工厂的接口,此外工厂可以生产多个产品,因此至少两个产品的接口)
     * @Date: 2020/5/18 10:07
     * @Idea: 抽象工厂的意思是工厂类具有顶级的接口, 在使用到某个具体的工厂类时可以生产对应的对象, 然后这个具体的工厂不止生产一种产品,而是可以生产不同的产品,因此这个不同产品对应不同的顶级接口;
     * 增加新的具体工厂和产品族很方便，无须修改已有系统，符合“开闭原则”。
     * <p>
     * 比如我还要增加一个Hbase的连接和指令执行,则只需要实现Connection和Command接口,然后创建一个具体的工厂实现DataBaseFactory接口即可;App端只要更改具体工厂的注入即可;
     * <p>
     * <p>
     * 在以下情况下可以使用抽象工厂模式：
     * 一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是重要的。
     * 系统中有多于一个的产品族，而每次只使用其中某一产品族。
     * 属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来。
     * 系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。
     * <p>
     * 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式。
     * 抽象工厂模式包含四个角色：抽象工厂用于声明生成抽象产品的方法；具体工厂实现了抽象工厂声明的生成抽象产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中；抽象产品为每种产品声明接口，在抽象产品中定义了产品的抽象业务方法；具体产品定义具体工厂生产的具体产品对象，实现抽象产品接口中定义的业务方法。
     * 抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形态。抽象工厂模式与工厂方法模式最大的区别在于，工厂方法模式针对的是一个产品等级结构，而抽象工厂模式则需要面对多个产品等级结构。
     * 抽象工厂模式的主要优点是隔离了具体类的生成，使得客户并不需要知道什么被创建，而且每次可以通过具体工厂类创建一个产品族中的多个对象，增加或者替换产品族比较方便，增加新的具体工厂和产品族很方便；主要缺点在于增加新的产品等级结构很复杂，需要修改抽象工厂和所有的具体工厂类，对“开闭原则”的支持呈现倾斜性。
     * 抽象工厂模式适用情况包括：一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节；系统中有多于一个的产品族，而每次只使用其中某一产品族；属于同一个产品族的产品将在一起使用；系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。
     */
    public static void main(String[] args) {

//        DataBaseFactory dataBaseFactory = new MysqlFactory();
        DataBaseFactory dataBaseFactory = new OracleFactory();
        Connection connection = dataBaseFactory.getConnection();
        connection.connect();

        Command command = dataBaseFactory.getCommand();
        command.execute();

    }
}
