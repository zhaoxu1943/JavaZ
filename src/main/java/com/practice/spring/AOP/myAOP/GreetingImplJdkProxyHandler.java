package com.practice.spring.AOP.myAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaoxu
 * @className GreetingImplJdkProxyHandler
 * @projectName JavaConcentration

 * @date 4/9/2020 10:56 PM
 */
public class GreetingImplJdkProxyHandler implements InvocationHandler {

    private GreetingImpl greeting;

    public GreetingImplJdkProxyHandler(GreetingImpl greeting) {
        this.greeting= greeting;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        Object result = method.invoke(greeting,args);
        System.out.println("after");
        return result;
    }
}
