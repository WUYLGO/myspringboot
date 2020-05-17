package com.wyl.research.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Description: 全局异常处理
 * @auther: wuyunlong
 * @date: 2020/5/16
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
    * @Description:
    * @Date: 2020/5/16 22:41
    * @Idea: 异常捕获按照就近原则,只会捕捉一次
    */
    @ExceptionHandler(value = Exception.class)
    public String handle(Exception e) {
        return e.getMessage();

    }

}
