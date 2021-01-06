package com.practice.spring.AOP.myAOP;

/**
 * @author zhaoxu
 * @className GreetingImplStaticProxy
 * @projectName JavaConcentration
 * @description 静态代理实现切面
 * @date 4/9/2020 10:40 PM
 */

public class GreetingImplStaticProxy implements  Greeting{


    //声明一个私有的成员变量
    private  GreetingImpl greetingImpl;

        //构造方法传入被代理类的实例
    public GreetingImplStaticProxy(GreetingImpl greetingImpl) {
        //this指代类的对象,将参数赋值给类对象
        this.greetingImpl= greetingImpl;
    }

    //重写方法
    @Override
    public void sayHello(String name) {
            before();
            greetingImpl.sayHello(name);
            after();



    }


        public static void before(){
        System.out.println("before method~");
    }

    public static void after(){
        System.out.println("after method~");
    }
}
