package com.wyl.research.designpattern.BuildPattern;

import javax.lang.model.element.NestingKind;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class Director {
    private Builder builder;


    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product createProduct(String partA, String partB, String partC, String partD) {
        return builder.buildPartA(partA)
                .buildPartB(partB)
                .buildPartC(partC)
                .buildPartD(partD).build();
    }


}
