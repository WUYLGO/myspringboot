package com.wyl.research.util.Bean;

import lombok.Data;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/3
 */
@Data
public class User extends Person {


    private static String name = "aaaa";
    private String age;

    static {
        name = "bbbb";
        System.out.println("user静态被执行...");
    }

}
