package com.john.dynamicaproxy;

/**
 * @author:wenwei
 * @date:2020/02/24
 * @description:
 */
public class ProxyTest {
    public static void main(String[] args) {
        System.out.println("不使用代理类，调用read");
        Person john = new John();
        john.read();
        System.out.println("---------------");

        System.out.println("使用代理类");

        Person proxy = (Person) new JDKDynamicProxy(new John()).getTarget();

        proxy.read();
    }
}
