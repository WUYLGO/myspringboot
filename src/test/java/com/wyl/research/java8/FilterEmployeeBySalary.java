package com.wyl.research.java8;

import com.wyl.research.validUser.User;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/20
 */
public class FilterEmployeeBySalary implements FilterRule<User> {
    @Override
    public boolean filter(User user) {
        return user.getSalary() > 7000;
    }
}
