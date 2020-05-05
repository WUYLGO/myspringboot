package com.example.demo.util.proxy;

public class MonitorUtil {

    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    public static void start(){
        threadLocal.set(System.currentTimeMillis());
    }
    public static void finish(String methodName){
        long finishTime=System.currentTimeMillis();
        System.out.println(methodName+"方法执行耗时为："+(finishTime-threadLocal.get())+"ms");
    }

}
