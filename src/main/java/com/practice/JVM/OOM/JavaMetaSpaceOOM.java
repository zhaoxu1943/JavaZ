package com.practice.JVM.OOM;

import com.concentration.util.JadyerUtil;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName JavaMetaSpace
 * @Description 探究MetaSpace
 * @Author zhaoxu
 * @Date 2019/12/6 3:24
 * @Version 1.0
 *
 * 在该包中的Enhancer类和MethodInterceptor接口是整个包的核心
 * cglib类代理的基本思想就是对被代理类生成一个新的类（proxy），该类是继承自被代理类的
 * 并对被代理类方法执行前后执行一些操作，这些操作的通常就是一些回调操作
 *
 * 其中MethodInterceptor是最常用的。
 * MethodInterceptor是一个提供环绕通知的通用回调接口！Aop中有这样的术语，那就是前置通知，后置通知，环绕通知，非常好理解，就是一个在方法执行前的通知，一个方法执行后的通知，另外一个就是方法执行前后都通知。
 * 该接口只有一个intercept()方法：
 *

 *
 **/
public class JavaMetaSpaceOOM {



        /**
         * JVM参数:-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
         */
        public static void main(String[] args) {

            while(true) {
                //创建一个Enhancer对象
                Enhancer enhancer = new Enhancer();
                System.out.println(JadyerUtil.getCurrentMethodName());;
                //设置被代理的类
                enhancer.setSuperclass(OOMObject.class);
                //不使用cache
                enhancer.setUseCache(false);
                //创建一个回调接口
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        //o是代理后的子类,method是调用方法,proxy是代理对象
                        System.err.println("原方法名是 ： " + method.getName());
                        System.err.println("原方法声明的类为 " + method.getDeclaringClass());
                        System.err.println("我是 " + methodProxy.invokeSuper(o, args));
                        System.err.println("我调用结束了");
                        return null;
                    }
                });
                OOMObject oomObject = (OOMObject) enhancer.create();
                //动态增强了所有方法
                oomObject.print();
                oomObject.register();
            }



        }

        static class OOMObject {
            void print(){
                System.out.println("mid");
            }

            void register() {
                System.out.println("top");
            }
        }

    }

