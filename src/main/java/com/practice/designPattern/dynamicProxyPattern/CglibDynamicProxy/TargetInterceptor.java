package com.practice.designPattern.dynamicProxyPattern.CglibDynamicProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhaoxu
 * @className TargetInterceptor
 * @projectName JavaConcentration
 * @description 目标对象拦截器 implements MethodInterceptor
 * @date 3/18/2020 10:38 AM
 */
public class TargetInterceptor implements MethodInterceptor {


    //示例在方法前后加入业务
    //Object obj 为目标对象,
    //method为目标方法,
    //objects为参数
    //methodProxy是cglib方法代理对象
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        System.err.println("原方法名是 ： " + method.getName());
        System.err.println("原方法声明的类为 " + method.getDeclaringClass());
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("调用后"+result);
        return result;
    }
}
