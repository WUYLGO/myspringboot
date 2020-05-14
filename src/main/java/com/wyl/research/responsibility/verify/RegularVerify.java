package com.wyl.research.responsibility.verify;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularVerify extends AbsVerify {
 
    protected String regular;//正则表达式
 
    public RegularVerify(String data, String regular, String errorMsg) {
        super(data,errorMsg);
        this.regular = regular;
    }
 
    //是否允许为空
    protected boolean allowEmpty() {
        return false;
    }
 
    @Override
    public boolean doVerify() {
        if (isEmpty(data)) {
            return allowEmpty() ? doNextFilter() : showErrorMsg(errorMsg);
        }
        return matcher() ? doNextFilter() : showErrorMsg(errorMsg);
    }
 
    //正则表达式
    private boolean matcher() {
        Pattern p = Pattern.compile(regular);
        Matcher m = p.matcher(data);
        return m.matches();
    }
}