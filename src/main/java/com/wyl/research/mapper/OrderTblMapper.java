package com.wyl.research.mapper;

import com.wyl.research.model.OrderTbl;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderTblMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderTbl record);

    OrderTbl selectByPrimaryKey(Integer id);

    List<OrderTbl> selectAll();

    int updateByPrimaryKey(OrderTbl record);
}