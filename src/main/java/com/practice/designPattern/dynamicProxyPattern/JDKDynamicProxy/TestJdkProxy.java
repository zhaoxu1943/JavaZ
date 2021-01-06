package com.practice.designPattern.dynamicProxyPattern.JDKDynamicProxy;

import com.practice.designPattern.proxyPattern.BlogServiceImpl;
import com.practice.designPattern.proxyPattern.IBlogService;

import java.lang.reflect.Proxy;

public class TestJdkProxy {
    public static void main(String[] args) {

        //创建处理类实例
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new BlogServiceImpl());


        //获取代理类实例dynamicProxy
        //获取实例的三个参数
        //loader：定义了代理类的ClassLoader;
        //interfaces：代理类实现的接口列表
        // h：调用处理器，也就是我们上面定义的实现了InvocationHandler接口的类实例
        IBlogService proxyInstance = (IBlogService)(Proxy.newProxyInstance(IBlogService.class.getClassLoader(), new Class[] {IBlogService.class}, myInvocationHandler));

        System.out.println(proxyInstance.getClass().getName());

        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        proxyInstance.writeBlog();
        proxyInstance.releaseBlog();

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }


}