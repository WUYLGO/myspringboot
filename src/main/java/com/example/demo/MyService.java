package com.example.demo;

import com.example.demo.model.OrderTbl;

import java.util.List;

public interface MyService {
    String test();

    List<OrderTbl> testMybatis();

    void insert();

    void insert2();
}
