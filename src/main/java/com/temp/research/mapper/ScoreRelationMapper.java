package com.temp.research.mapper;

import com.temp.research.model.ScoreRelation;

public interface ScoreRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScoreRelation record);

    int insertSelective(ScoreRelation record);

    ScoreRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScoreRelation record);

    int updateByPrimaryKey(ScoreRelation record);
}