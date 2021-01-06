package com.practice.spring.AOP.myAOP;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhaoxu
 * @className GreetingImplStaticProxyTest
 * @projectName JavaConcentration

 * @date 4/9/2020 10:49 PM
 */
public class GreetingImplStaticProxyTest {

    @Test
    public void sayHello() {
    GreetingImplStaticProxy greetingImplStaticProxy = new GreetingImplStaticProxy(new GreetingImpl());
    greetingImplStaticProxy.sayHello("nihao");
    }
}