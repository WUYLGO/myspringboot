package com.wyl.research.designpattern.FactoryMethodPattern;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class ProductFactoryImplA implements ProductFactory {
    @Override
    public Product getProduct() {
        return new ProductImplA();
    }
}
