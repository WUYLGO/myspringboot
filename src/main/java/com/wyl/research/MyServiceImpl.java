package com.wyl.research;

import com.wyl.research.mapper.OrderTblMapper;
import com.wyl.research.model.OrderTbl;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
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
        System.out.println("===>MyServiceImpl的构造方法被执行...");
    }

    /**
    * @Description: //TODO
    * @Date: 2020/5/14 17:44
    * @Idea: @PostConstruct是在依赖注入完成之后执行,也就是bean初始化赋值完成,并且后置处理器完成之后才调用;
    */
    @PostConstruct
    public void init() {
        System.out.println("===>init方法执行了....");
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
//        OrderTbl orderTbl = new OrderTbl();
//        orderTbl.setUserId("bbbbbbbbbbbb");
//        orderTblMapper.insert(orderTbl);


//        MyServiceImpl myServiceImpl = (MyServiceImpl) applicationContext.getBean("myServiceImpl");
//        myServiceImpl.insert2();

        for (int i = 0; i < 10000; i++) {
            ((MyService) AopContext.currentProxy()).insert2();
        }


//        this.insert2();

//        myServiceImpl2.undoLog();

//        int c = 1 / 0;
    }

    final Random random = new Random(25);

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insert2() {
        OrderTbl orderTbl2 = new OrderTbl();
        orderTbl2.setUserId("CCCCCCCCCCCC" + randomInt());
        orderTbl2.setCommodityCode("GGGGGGGG" + randomInt());
        orderTbl2.setCount(randomInt());
        orderTbl2.setMoney(randomInt());
        orderTbl2.setRank(null);
        orderTbl2.setSort(randomInt());
        orderTbl2.setAddr("中国深圳" + randomInt());
        orderTblMapper.insert(orderTbl2);

//        int c = 1 / 0;
    }

    public int randomInt() {
        return Math.abs(random.nextInt());
    }


}
