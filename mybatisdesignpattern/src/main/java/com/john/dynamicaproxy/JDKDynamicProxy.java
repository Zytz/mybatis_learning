package com.john.dynamicaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:wenwei
 * @date:2020/02/24
 * @description:
 */
//mybatis使用mapperProxyFactory,mapperProxy核心工厂模式

/**
 * mybatis通过mapperProxy.invoker 本质是sqlsession.执行sql语句
 */
public class JDKDynamicProxy implements InvocationHandler{
    //生命被代理对象
    private Person person;

    //  构造函数
    public JDKDynamicProxy(Person person) {
        this.person = person;
    }

    public Object getTarget(){
        Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
        return null;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("对原方法进行前置增强");
        //愿方法执行
        Object invoke = method.invoke(person, args);
        System.out.println("对原方法进行后置增强");

        return null;
    }
}
