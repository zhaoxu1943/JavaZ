package com.practice.designPattern.dynamicProxyPattern.CglibDynamicProxy;

import com.practice.designPattern.proxyPattern.BlogServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zhaoxu
 * @className JavaCglib
 * @projectName JavaConcentration

 * @date 3/16/2020 12:13 PM

 */

public class JavaCglib {
    public static void main(String[] args) {
        //创建类增强对象
        Enhancer enhancer = new Enhancer();
        //设置代理类,其实就是父类
        enhancer.setSuperclass(BlogServiceImpl.class);
        //创建回调接口
        enhancer.setCallback(new TargetInterceptor());


        //create()动态生成一个代理类
        BlogServiceImpl blogService = (BlogServiceImpl) enhancer.create();

        //方法调用
        blogService.writeBlog();
        blogService.releaseBlog();

    }
}
