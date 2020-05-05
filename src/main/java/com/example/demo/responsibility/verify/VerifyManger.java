package com.example.demo.responsibility.verify;

import java.util.ArrayList;
import java.util.List;

public class VerifyManger {
 
    //校验器集合
    private List<Verify> verifies = new ArrayList<>();
 
    //添加校验器
    public VerifyManger addVerify (Verify verify) {
        verifies.add(verify);
        return this;
    }
 
    //执行校验器
    public boolean execute() {
        if (verifies.isEmpty()) {
            return true;
        }
        int size = verifies.size();
        if (size == 1) {
            return verifies.get(0).doVerify();
        }
        for (int i = 0; i < size; i++) {
            Verify verify = verifies.get(i);
            if (i + 1 < size) {
                verify.setNextVerify(verifies.get(i + 1));
            }
        }
        return verifies.get(0).doVerify();
    }
}