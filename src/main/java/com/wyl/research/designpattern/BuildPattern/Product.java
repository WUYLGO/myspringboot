package com.wyl.research.designpattern.BuildPattern;

import lombok.Data;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
@Data
public class Product {

    private String partA;
    private String partB;
    private String partC;
    private String partD;

    public Product() {

    }

    public Product(String partA, String partB, String partC, String partD) {
        this.partA = partA;
        this.partB = partB;
        this.partC = partC;
        this.partD = partD;

    }

}
