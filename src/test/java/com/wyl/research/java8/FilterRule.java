package com.wyl.research.java8;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/20
 */
public interface FilterRule<T> {
    boolean filter(T t);
}
