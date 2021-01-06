package com.practice.spring.AOP.myAOP;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * @author zhaoxu
 * @className GreetingImplJdkProxyHandlerTest
 * @projectName JavaConcentration

 * @date 4/9/2020 10:59 PM
 */
public class GreetingImplJdkProxyHandlerTest {

    @Test
    public void invoke() {

        Greeting greeting =(Greeting)Proxy.newProxyInstance(Greeting.class.getClassLoader(),new Class[]{Greeting.class},new GreetingImplJdkProxyHandler(new GreetingImpl()));
        greeting.sayHello("zhaoxu ");

    }
}