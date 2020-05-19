package com.wyl.research;

import com.alibaba.fastjson.JSON;
import com.wyl.research.model.OrderTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.beans.Encoder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@RestController
public class MyController {

    /**
     * @Description: 依赖注入
     * @Date: 2020/5/19 16:21
     * @Idea: @Autowired根据类型注入,因此当一个接口有多个实现类的时候无法注入成功;
     * @Resource(name = "myServiceImplCopy") :首先根据名称注入,名称找不到根据类型进行注入(对象名称注入),名称标注在各个实现类的@Component(value="aaaa")里面
     * @Qualifier("MyServiceImplCopy") 根据名称注入, 但是是根据类名注入;
     */
    @Autowired
//    @Resource(name = "myServiceImplCopy")
//    @Qualifier("MyServiceImplCopy")
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
//            response.sendRedirect("http://www.baidu.com");
            response.sendRedirect("http://localhost:8888/test/redirect2?name=tom&age=14");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/test/redirect2")
    public String testValid2(@RequestParam("name") String name, @RequestParam("age") Integer age, HttpServletRequest request, HttpServletResponse response) {
        return name + age;
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
//    @ExceptionHandler(value = Exception.class)
//    public String handle(Exception e) {
//        return e.getMessage();
//
//    }
}
