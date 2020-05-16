package com.wyl.research;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/16
 */
@Component
public class InitBean implements InitializingBean {

    @PostConstruct
    public void testPostConstract(){
        System.out.println("testPostConstract===>");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("afterPropertiesSet==>");
    }
}
