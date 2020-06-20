package com.wyl.research.validUser;

import lombok.Data;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/24
 */
@Data
public class User {
    @NotNull(value = "用户名不能为空")
    private String userName;
    private String password;

    private int age;

    private double salary;


    public User() {
    }

    public User(String userName, int age, double salary) {
        this.userName = userName;
        this.age = age;
        this.salary = salary;
    }

}
