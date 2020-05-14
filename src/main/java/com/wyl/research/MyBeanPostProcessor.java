package com.wyl.research;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/14
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
    * @Description: //TODO
    * @Date: 2020/5/14 17:44
    * @Idea: BeanPostProcessor这个前置处理器和后置处理器是在bean创建之后在bean的初始化过程的前后进行前置处理和后置处理,
     * 也就是在该类的构造方法调用完成创建了这个bean的时候才开始前置和后置处理;
    */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("myServiceImpl")) {
            System.out.println("===>bean初始化的前置方法执行");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("myServiceImpl")) {
            System.out.println("===>bean初始化的后置方法执行");
        }

        return bean;
    }
}
