package com.wyl.research.responsibility.verify;

import org.springframework.util.StringUtils;

public abstract class AbsVerify implements Verify {

    protected String data;//校验数据
    protected String errorMsg;//失败信息

    protected Verify nextVerify;   //下个执行的校验器
    protected VerifyCallBack callBack;

    public AbsVerify(String data, String errorMsg) {
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public void setNextVerify(Verify verify) {
        this.nextVerify = verify;
    }

    @Override
    public boolean showErrorMsg(String errorMsg) {
        if (callBack != null) {
            callBack.failure();
        }
        if (!isEmpty(errorMsg)) {
            System.out.println(errorMsg);
        }
        return false;
    }

    //执行下一个校验
    protected boolean doNextFilter() {
        if (callBack != null) {
            callBack.sussecc();
        }
        return nextVerify != null ? nextVerify.doVerify() : true;
    }

    //是否为空
    protected boolean isEmpty(String msg) {
        return StringUtils.isEmpty(msg);
    }

    public VerifyCallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(VerifyCallBack callBack) {
        this.callBack = callBack;
    }
}