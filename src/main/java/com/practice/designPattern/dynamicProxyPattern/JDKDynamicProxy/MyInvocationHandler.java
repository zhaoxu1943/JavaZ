package com.practice.designPattern.dynamicProxyPattern.JDKDynamicProxy;

import com.practice.designPattern.proxyPattern.IBlogService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//首先实现接口,实现自己的InvocationHandler
//区别与静态代理,代理类要自己写,动态代理类是动态生成的字节码,
// 并由传入的类加载器加载
public class MyInvocationHandler implements InvocationHandler {

    //首先同静态代理一样 new出被代理类的对象
    private IBlogService blogService;

    //构造方法
    public MyInvocationHandler(IBlogService blogService) {
        this.blogService = blogService;
    }


    @Override
    //参数为
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("DynamicStart...");
        //result 为方法返回的结果
        Object result = method.invoke(blogService, args);
        System.out.println("DynamicEnd...");
        return result;
    }
}

