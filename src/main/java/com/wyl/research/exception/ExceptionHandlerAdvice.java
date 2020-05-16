package com.wyl.research.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/16
 */
//@Component
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    public String handle(Exception e) {
        return e.getMessage();

    }

}
