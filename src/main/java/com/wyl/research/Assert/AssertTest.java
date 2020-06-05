package com.wyl.research.Assert;


import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/1
 */
public class AssertTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("aa");
        Assert.notEmpty(list, "集合不能为空");
        System.out.println("结束.....");


        Object o = new Object();
        Object o1 = new Object();

    }

}
