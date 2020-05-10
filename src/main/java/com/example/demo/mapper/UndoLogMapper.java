package com.example.demo.mapper;

import com.example.demo.model.UndoLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UndoLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UndoLog record);

    UndoLog selectByPrimaryKey(Long id);

    List<UndoLog> selectAll();

    int updateByPrimaryKey(UndoLog record);
}