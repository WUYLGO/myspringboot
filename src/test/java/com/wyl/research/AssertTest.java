package com.wyl.research;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/1
 */
public class AssertTest {


    /**
     * @Description: 单元测试放到test source下面
     * @Date: 2020/6/1 11:36
     * @Idea: 注意Junit下的Assert只能在test source下面使用;
     */
    @Test
    public void test() {
        Assert.assertEquals("s", "s");
//        Assert.assertEquals(new Object(), new Object());
        System.out.println("结束....");

    }

}
