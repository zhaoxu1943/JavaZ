package com.practice.designPattern;

import com.practice.designPattern.proxyPattern.BlogServiceImpl;
import com.practice.designPattern.proxyPattern.BlogStaticProxy;
import com.practice.designPattern.proxyPattern.IBlogService;
import org.junit.Test;

public class BlogStaticProxyTest {

    @Test
    public void writeBlog() {
        IBlogService target = new BlogServiceImpl();
        BlogStaticProxy proxy = new BlogStaticProxy(target);
        proxy.writeBlog();
        proxy.releaseBlog();

    }
}