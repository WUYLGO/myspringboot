package com.wyl.research;

import com.alibaba.fastjson.JSON;
import com.wyl.research.model.OrderTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
