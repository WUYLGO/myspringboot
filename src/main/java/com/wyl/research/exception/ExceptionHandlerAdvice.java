package com.wyl.research.exception;

import com.wyl.research.validUser.BusinessException;
import com.wyl.research.validUser.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局异常处理
 * @auther: wuyunlong
 * @date: 2020/5/16
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    /**
     * @Description:
     * @Date: 2020/5/16 22:41
     * @Idea: 异常捕获按照就近原则, 只会捕捉一次
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        log.error("发生异常 :  ", e);
        if (e instanceof BusinessException) {
            BusinessException e1 = (BusinessException) e;
            return Result.buildErrorMsg(e1.getErrorMessage(), e1.getErrorCode());
        } else {
            return Result.buildErrorMsg(e.getMessage(), "9999");
        }

    }

}
