package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = "com.example.demo.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
public class MyspringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootDemoApplication.class, args);
    }

}
