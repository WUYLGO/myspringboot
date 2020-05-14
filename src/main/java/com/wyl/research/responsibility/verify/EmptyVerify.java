package com.wyl.research.responsibility.verify;

public class EmptyVerify extends AbsVerify {
 
    public EmptyVerify(String data, String errorMsg) {
        super(data, errorMsg);
    }
 
    @Override
    public boolean doVerify() {
        return isEmpty(data) ? showErrorMsg(errorMsg) : doNextFilter();
    }
}