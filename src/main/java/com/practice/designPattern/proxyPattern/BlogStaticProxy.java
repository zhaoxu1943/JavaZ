package com.practice.designPattern.proxyPattern;


//静态代理对象，通过构造方法获取到目标对象，并实现了目标接口
//在目标接口的方法里调用了目标对象的方法

//继承了目标对象的接口
public class BlogStaticProxy implements IBlogService {

    //new了对象,只要是实现IBlogService的对象都可以传入
    private IBlogService blogService;

    //构造方法
    public BlogStaticProxy(IBlogService blogService) {
        this.blogService = blogService;
    }

    //静态代理会造成代码重复,且接口所有的方法都要去实现
    @Override
        public void releaseBlog() {
            System.out.println("StaticStart...");
            blogService.releaseBlog();
            System.out.println("StaticEnd...");
    }

    //添加了新的方法,我的理解它相当于一个MVC架构中的Controller,new了Service
    //然后添加了一些 方法
    @Override
    public void writeBlog() {
        System.out.println("StaticStart...");
        blogService.writeBlog();
        System.out.println("StaticEnd...");
    }
}