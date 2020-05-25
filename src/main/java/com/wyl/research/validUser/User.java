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

}
