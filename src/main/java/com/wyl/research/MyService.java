package com.wyl.research;

import com.wyl.research.model.OrderTbl;

import java.util.List;

public interface MyService {
    String test();

    List<OrderTbl> testMybatis();

    void insert();

    void insert2();
}
