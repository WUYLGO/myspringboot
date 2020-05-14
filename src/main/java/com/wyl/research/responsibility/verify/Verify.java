package com.wyl.research.responsibility.verify;

public interface Verify {
    //校验
    boolean doVerify();
    //设置下个校验器
    void setNextVerify(Verify verify);
    //显示错误信息
    boolean showErrorMsg(String errorMsg);
    //执行校验回调（提供支持，项目未使用到）
    interface VerifyCallBack {
        //成功
        void sussecc();
        //失败
        void failure();
    }
}