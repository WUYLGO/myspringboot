package com.wyl.research.util.proxy;

import java.lang.reflect.Proxy;

public class JdkDynamicProxyTest {
    public static void main(String[] args) {

        Person person = new PersonImpl();
        person.setName("张三F");
        //创建代理对象
        Person personProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), Person.class.getInterfaces(), new PersonInvocationHandle<Person>(person) {
        });
        personProxy.goWorking();

    }
}
