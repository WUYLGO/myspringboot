package com.example.demo.responsibility.verify;

public class AllowEmptyVerify extends RegularVerify {
 
    public AllowEmptyVerify(String data, String regular, String errorMsg) {
        super(data, regular, errorMsg);
    }
 
    @Override
    protected boolean allowEmpty() {
        return true;
    }
}