package com.practice.designPattern.proxyPattern;

/**
 * @author zhaoxu
 * @className BlogClient
 * @projectName JavaConcentration

 * @date 2/18/2020 9:44 PM
 */
public class BlogClient {


    public static void main(String[] args) {
        BlogStaticProxy blogStaticProxy = new BlogStaticProxy(new BlogServiceImpl());

        //using proxy class
        blogStaticProxy.writeBlog();
        blogStaticProxy.releaseBlog();

    }


}
