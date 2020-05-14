package com.example.demo.javaBaseTest;

import lombok.Data;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/14
 */
@Data
public class Son extends Parent {

    private String name;

    public Son() {
        System.out.println("son的无参构造方法...");
    }

    public Son(String name) {
        System.out.println("son的有参构造方法...");
        this.name = name;
    }


}
