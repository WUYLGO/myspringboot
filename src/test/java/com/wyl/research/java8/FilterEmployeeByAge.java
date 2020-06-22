package com.wyl.research.java8;

import com.wyl.research.validUser.User;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/20
 */
public class FilterEmployeeByAge implements FilterRule<User> {
    @Override
    public boolean filter(User user) {
        return user.getAge() >= 35;
    }

}
