package com.example.demo.mapper;

import com.example.demo.model.UndoLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UndoLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UndoLog record);

    UndoLog selectByPrimaryKey(Long id);

    List<UndoLog> selectAll();

    int updateByPrimaryKey(UndoLog record);


    /**
    * @Description: //TODO
    * @Date: 2020/5/10 11:35
    * @Idea: 为什么表名要用$而不用#,因为用#会被预编译为?,后续无法正常拼接表名,因为会被当成参数带上单引号'';
    */
    @Select("select * from ${tableName} where xid = #{xid}")
    List<UndoLog> selectByXid(@Param("tableName") String tableName, @Param("xid") String xid);

}