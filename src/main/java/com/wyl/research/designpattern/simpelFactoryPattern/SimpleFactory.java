package com.wyl.research.designpattern.simpelFactoryPattern;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class SimpleFactory {


    public static Product getProduct(int type) {
        if (type == 0) {
            return new ProductImplA();
        } else if (type==1) {
            return new ProductImplB();
        }
        throw new RuntimeException("找不到合法的产品...");

    }

}
