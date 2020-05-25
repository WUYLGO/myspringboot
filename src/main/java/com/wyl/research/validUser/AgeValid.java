package com.wyl.research.validUser;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/24
 */
public class AgeValid implements Valid {
    private int value;

    public AgeValid(int age) {
        this.value = age;
    }


    @Override
    public boolean valid() {
        if (value < 0) {
//            throw new RuntimeException("年龄不合法...");
            throw new BusinessException(ResponseEnum.AGE_ERROR);
        } else {
            System.out.println("年龄校验通过...");
            return true;
        }

    }
}
