package com.wyl.research.responsibility.verify;

public class Regular {
 
    //密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)
    public static final String PASSWORD = "^[a-zA-Z]\\w{6,18}$";
    //用户名(中文、英文、数字包括下划线)
    public static final String NAME = "^[\\u4E00-\\u9FA5A-Za-z0-9_]+$";
    //手机号
    public static final String PHONE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
 
}