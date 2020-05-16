package com.wyl.research;

import com.alibaba.fastjson.JSON;
import com.wyl.research.model.OrderTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    @Autowired
    private MyService2 myService2;

    @RequestMapping("/test")
    public String getBigDecimal() {
        return myService.test();
    }

    @RequestMapping("/test/mybatis")
    public void testMybatis() {
        myService2.undoLog();
    }

    @RequestMapping("/test/valid")
    public String testValid(@Valid @RequestBody OrderTbl orderTbl) {
        return JSON.toJSONString(orderTbl);
    }


    @RequestMapping("/test/redirect")
    public void testValid(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("http://www.baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/test/exception")
    public String testException(HttpServletRequest request, HttpServletResponse response) {
        int i = 1 / 0;

        return "success";

    }


    /**
    * @Description: 异常捕获
    * @Date: 2020/5/16 22:32
    * @Idea:   @ExceptionHandler注解用来实现单个controller的异常捕获,同一个controller里面不能用捕捉多个相同的异常,否则报错
    */
    @ExceptionHandler(value = Exception.class)
    public String handle(Exception e) {
        return e.getMessage();

    }
}
