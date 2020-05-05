package com.example.demo.responsibility.verify;

public class Test {
    static String name = "童心未泯佐为";
    static String password = "qqwwee123";
    static String phone = "";
 
    public static void main(String args[]) {
 
        boolean execute = new VerifyManger()
                .addVerify(new EmptyVerify(name, "请填写用户名"))
                .addVerify(new RegularVerify(name, Regular.NAME, "用户名格式不正确"))
 
                .addVerify(new EmptyVerify(password, "请填写密码"))
                .addVerify(new RegularVerify(password, Regular.PASSWORD, "密码格式不正确"))
 
                .addVerify(new AllowEmptyVerify(phone, Regular.PHONE, "手机号格式不正确"))//非必填 允许为空 有值校验
                .execute();
        if (execute) {
            System.out.println("校验通过");
        }
    }
}