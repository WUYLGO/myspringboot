package com.wyl.research.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderTbl {
    @NotNull(message = "id不能为空")
    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;

    private Integer rank;

    private Integer sort;

    private String addr;

}