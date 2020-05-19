package com.wyl.research.designpattern.BuildPattern;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/18
 */
public class ProductABuilder implements Builder {
    private String partA;
    private String partB;
    private String partC;
    private String partD;


    @Override
    public Builder buildPartA(String partA) {
        this.partA = partA;
        return this;
    }

    @Override
    public Builder buildPartB(String partB) {
        this.partB = partB;
        return this;
    }

    @Override
    public Builder buildPartC(String partC) {
        this.partC = partC;
        return this;
    }

    @Override
    public Builder buildPartD(String partD) {
        this.partD = partD;
        return this;
    }

    @Override
    public Product build() {
        return new Product(partA, partB, partC, partD);
    }

}
