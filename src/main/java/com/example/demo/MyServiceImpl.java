package com.example.demo;

import com.example.demo.mapper.OrderTblMapper;
import com.example.demo.model.OrderTbl;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class MyServiceImpl implements MyService {
    @Autowired
    private AnsyTest ansyTest;

    @Autowired
    private OrderTblMapper orderTblMapper;

    public MyServiceImpl() {
        System.out.println("..........");
    }


    @Autowired
    private MyServiceImpl2 myServiceImpl2;

    @Override
    public String test() {
        System.out.println("进入service......." + Thread.currentThread().getName());
        Future future = ansyTest.asyncTask();
        Future future1 = ansyTest.asyncTask2();
        System.out.println("主方法等待异步任务执行");
        boolean flag1 = false;
        boolean flag2 = false;
        while (true) {
            if (!flag1) {
                if (future.isDone()) {
                    System.out.println("asyncTask异步任务完成...");
                    try {
                        Object o = future.get(60, TimeUnit.SECONDS);
                        System.out.println("object--->" + o);
                    } catch (InterruptedException | TimeoutException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    flag1 = true;
                }
            }
            if (!flag2) {
                if (future1.isDone()) {
                    System.out.println("asyncTask2异步任务完成...");
                    try {
                        Object o = future1.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    flag2 = true;
                }
            }
            if (flag1 && flag2) {
                break;
            }
        }
        System.out.println("主方法结束.....");
        return "success";

    }

    @Override
    public List<OrderTbl> testMybatis() {
        List<OrderTbl> orderTbls = orderTblMapper.selectAll();
        return orderTbls;
    }


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void insert() {
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId("bbbbbbbbbbbb");
        orderTblMapper.insert(orderTbl);


//        MyServiceImpl myServiceImpl = (MyServiceImpl) applicationContext.getBean("myServiceImpl");
//        myServiceImpl.insert2();


        ((MyServiceImpl) AopContext.currentProxy()).insert2();


//        this.insert2();

//        myServiceImpl2.undoLog();

//        int c = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insert2() {
        OrderTbl orderTbl2 = new OrderTbl();
        orderTbl2.setUserId("CCCCCCCCCCCC");
        orderTblMapper.insert(orderTbl2);

//        int c = 1 / 0;
    }


}
