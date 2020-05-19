package com.wyl.research.beanUtilsTest;

import lombok.Data;

import java.util.Date;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/19
 */
@Data
public class UserVo {


    private String name;
    private int age;
    private Date date;
    private String address;

    private Sub sub;

    public UserVo() {

    }

    public UserVo(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }
}
