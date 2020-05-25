package com.wyl.research.validUser;

public enum ResponseEnum {
    PASSWORD_ERROR("9999", "密码错误"),
    USERNAME_ERROR("8888", "用户名错误"),
    AGE_ERROR("7777", "年龄不合法"),
    USER_ISNULL("6666", "用户不存在"),
    USER_NAME_ISNULL("5555", "用户名必传"),
    USER_NAME_ISVALID("4444", "用户名太短"),
    ;


    private String code;
    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
