package com.example.demo.javaBaseTest;

import lombok.Data;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/14
 */
@Data
public class Parent {

    private String name;

    public Parent() {
        System.out.println("Parent的无参构造方法...");
    }


    public Parent(String name) {
        System.out.println("Parent的有参构造方法...");
        this.name = name;
    }

}
