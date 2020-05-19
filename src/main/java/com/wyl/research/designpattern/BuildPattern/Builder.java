package com.wyl.research.designpattern.BuildPattern;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public interface Builder {
    Builder buildPartA(String partA);

    Builder buildPartB(String partB);

    Builder buildPartC(String partC);

    Builder buildPartD(String partD);


    Product build();


}



