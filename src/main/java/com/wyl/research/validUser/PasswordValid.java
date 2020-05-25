package com.wyl.research.validUser;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/24
 */
public class PasswordValid implements Valid {

    private String value;

    public PasswordValid(String s) {
        this.value = s;
    }

    @Override
    public boolean valid() {
        if (value.length() < 5) {
//            System.out.println("密码不合法...");
//            throw new RuntimeException("密码不合法...");
            throw new BusinessException(ResponseEnum.PASSWORD_ERROR);
        } else {
            System.out.println("密码校验通过..");
            return true;
        }

    }
}
