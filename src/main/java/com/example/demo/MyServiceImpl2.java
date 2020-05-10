package com.example.demo;

import com.example.demo.mapper.OrderTblMapper;
import com.example.demo.mapper.UndoLogMapper;
import com.example.demo.model.OrderTbl;
import com.example.demo.model.UndoLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class MyServiceImpl2 implements MyService2 {

    @Autowired
    private UndoLogMapper undoLogMapper;

    @Autowired
    private MyService myService;


    //    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void undoLog() {
        //表名
        List<UndoLog> aaaaaa = undoLogMapper.selectByXid("undo_log", "aaaaaa");

        undoLogMapper.selectByPrimaryKey(15L);

        UndoLog undoLog = new UndoLog();
        undoLog.setBranchId(155L);
        undoLog.setExt("aaaaaaaa");
        undoLog.setLogCreated(new Date());
        undoLog.setLogModified(new Date());
        undoLog.setLogStatus(1);
        undoLog.setRollbackInfo("aaaaa".getBytes());
        undoLog.setXid("aaaaaaaaaa");
        undoLogMapper.insert(undoLog);

        // useGeneratedKeys="true" keyProperty="id"==>增加这个配置可以获得刚插入数据的id值,只适用mysql自增主键;
        System.out.println("undoLog: id====>" + undoLog.getId());

        myService.insert();

//        UndoLog undoLog2 = new UndoLog();
//        undoLog2.setBranchId(155L);
//        undoLog.setExt("aaaaaaaa");
//        undoLog2.setLogCreated(new Date());
//        undoLog2.setLogModified(new Date());
//        undoLog2.setLogStatus(1);
//        undoLog2.setRollbackInfo("aaaaa".getBytes());
//        undoLog2.setXid("bbbbbbbbbbbb");

//        undoLogMapper.insert(undoLog2);
//        int a = 1 / 0;

    }
}
