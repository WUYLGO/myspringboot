package com.example.demo;

import com.example.demo.mapper.OrderTblMapper;
import com.example.demo.mapper.UndoLogMapper;
import com.example.demo.model.OrderTbl;
import com.example.demo.model.UndoLog;
import com.example.demo.util.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

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

    public static void parseSql(String originalSql, String parameters) {

        String replaceAll = parameters.replaceAll("\\((.*?)\\)", "");
        String[] split = replaceAll.split(",");
        LinkedList<String> params = new LinkedList<>();
        for (String s : split) {
            s = s.trim();
            System.out.println(s);
            params.add(s);

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : originalSql.toCharArray()) {
            if (c.equals('?')) {
                stringBuilder.append("'");
                stringBuilder.append(params.pollFirst());
                stringBuilder.append("'");
            } else {
                stringBuilder.append(c);
            }
        }
        stringBuilder.append(";");
        System.out.println(stringBuilder.toString());

    }

    public static void main(String[] args) {
        // String originalSql = "insert into order_tbl (user_id, commodity_code, count, money, rank, sort, addr) values (?, ?, ?, ?, ?, ?, ?) ";
        // String parameters = "CCCCCCCCCCCC(String), GGGGGGGG(String), 10(Integer), 100(Integer), 50(Integer), 60(Integer), 中国深圳(String)";
        String originalSql = "select * from undo_l" +
                "og where xid = ?";
        String parameters = "aaaaaa(String)";

        parseSql(originalSql, parameters);

        System.out.println(String.format("hello %s", "world"));

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock();

    }

}
