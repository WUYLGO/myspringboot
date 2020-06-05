package com.wyl.research;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/5
 */
@Configuration
public class BeanConfig {
    @Bean(initMethod = "init", destroyMethod = "destory")
    public BeanInitModel getBeanInitModel() {
        return new BeanInitModel();
    }

}
