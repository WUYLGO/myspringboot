package com.wyl.research;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = "com.wyl.research.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
public class MyspringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootDemoApplication.class, args);
    }

}
