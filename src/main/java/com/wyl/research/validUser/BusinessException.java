package com.wyl.research.validUser;

import lombok.Data;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/24
 */
@Data
public class BusinessException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public BusinessException(ResponseEnum responseEnum) {
        this.errorCode = responseEnum.getCode();
        this.errorMessage = responseEnum.getMessage();
    }

    public BusinessException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


}
