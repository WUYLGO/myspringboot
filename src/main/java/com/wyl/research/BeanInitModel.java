package com.wyl.research;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/5
 */
public class BeanInitModel implements InitializingBean {
    public void init() {
        System.out.println("BeanInitModel init 执行了...");
    }

    public void destory() {
        System.out.println("BeanInitModel destory 执行了...");
    }

    @PostConstruct
    public void init2() {
        System.out.println("BeanInitModel init2 方法执行了...");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("BeanInitModel afterPropertiesSet 方法执行了...");
    }
}
