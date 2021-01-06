package com.practice.spring.AOP.myAOP;

/**
 * @author zhaoxu
 * @className GreetingImpl
 * @projectName JavaConcentration

 * @date 4/9/2020 10:32 PM
 */
public class GreetingImpl implements Greeting{
    //自己实现AOP,那么这个实现接口的类就是一个Bean
    //要实现切面的逻辑,我们自己该怎么做呢?

    //首先自然是在一个类中,抽象出before(),after()
    //在方法中复用即可
    @Override
    public void sayHello(String name) {
        //before();
        System.out.println(name);
        //after();


    }

//    public static void before(){
//        System.out.println("before method~");
//    }
//
//    public static void after(){
//        System.out.println("after method~");
//    }


    //代码的坏味道,每个method中都要去引用

    //重构方案1
        //静态代理,在不修改bean本身的情况下,进行静态代理
        //见GreetingImplStaticProxy.java进行了静态代理
    //但是这样一个是修改接口后,代理类和被代理类改动较大
    //而且要是不同的策略下,如加日志./权限.会导致代理类越来越多,那么JDK动态代理就来了



}
