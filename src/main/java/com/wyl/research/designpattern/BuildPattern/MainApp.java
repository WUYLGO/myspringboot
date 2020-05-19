package com.wyl.research.designpattern.BuildPattern;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class MainApp {


    /**
     * @Description: 建造者模式==>创建型模式
     * @Date: 2020/5/18 12:27
     * @Idea: 隔离复杂对象的创建和使用，相同的方法，不同执行顺序，产生不同事件结果
     * 多个部件都可以装配到一个对象中，但产生的运行结果不相同
     * 产品类非常复杂或者产品类因为调用顺序不同而产生不同作用
     * 初始化一个对象时，参数过多，或者很多参数具有默认值
     * <p>
     * 总结Builder接口需要将需要创建的产品分成几个部分分别创建,然后再统一创建出对应的对象返回,即控制赋值的过程以及顺序;
     */
    public static void main(String[] args) {
        Builder builder = new DefaultProductBuilder();
        Product product = builder.buildPartA("aaa")
                .buildPartB("bbb")
                .buildPartC("ccc")
                .buildPartD("ddd").build();


        //使用建造者模式来控制对象的赋值过程,用于复杂对象的赋值可以使用
        Director director = new Director(new DefaultProductBuilder());
        director.createProduct("aaa", "bbb", "ccc", "ddd");


        System.out.println(product.toString());
    }
}
