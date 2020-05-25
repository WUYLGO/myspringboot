package com.wyl.research.validUser;

import lombok.Data;

@Data
public class Result {
    private Object data;
    private String errorMessage;
    private String errorCode;
    private boolean success;


    public static Result buildErrorMsg(String errorMessage, String errorCode) {
        Result result = new Result();
        result.setErrorCode(errorCode);
        result.setErrorMessage(errorMessage);
        result.setSuccess(false);
        return result;
    }

    public static Result buildSuccessMsg(Object data) {
        Result result = new Result();
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public static Result buildSuccessMsg() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }
}