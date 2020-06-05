package com.wyl.research.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/26
 */
public class CompareTest {

    /**
     * @Description: comparator排序
     * @Date: 2020/5/26 14:26
     * @Idea: 两个数比较的结果返回-1是升序,返回1是降序,返回0是不变;
     */
    public static void main(String[] args) {
        Apple apple1 = new Apple(2);
        Apple apple2 = new Apple(3);
        Apple apple3 = new Apple(1);


        List<Apple> apples = new ArrayList<>();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);

        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return 0;
            }
        });

        apples.forEach(t -> {
            System.out.println(t);
        });

    }

}
