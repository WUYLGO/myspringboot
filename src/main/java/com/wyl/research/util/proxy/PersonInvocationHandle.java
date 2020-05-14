package com.wyl.research.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * jdk的动态代理
 */
public class PersonInvocationHandle<T> implements InvocationHandler {
    T target;

    public PersonInvocationHandle(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被动态代理类回调执行, 代理类 proxyClass ="+proxy.getClass()+" 方法名: " + method.getName() + "方法. 方法返回类型："+method.getReturnType()
                +" 接口方法入参数组: "+(args ==null ? "null" : Arrays.toString(args)));
        MonitorUtil.start();
        Object invoke = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return invoke;
    }
}
