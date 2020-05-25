package com.wyl.research.validUser;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/24
 */
public class UserNameValid implements Valid {
    private String value;

    public UserNameValid(String s) {
        this.value = s;
    }

    @Override
    public boolean valid() {
        if (value.length() < 5) {
//            System.out.println("userName不合法...");
//            throw new RuntimeException("userName不合法...");
            throw new BusinessException(ResponseEnum.USERNAME_ERROR);
        } else {
            System.out.println("userName校验通过...");
            return true;
        }
    }
}
