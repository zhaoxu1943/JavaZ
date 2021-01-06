package com.practice.designPattern.proxyPattern;


//目标对象实现了目标接口
public class BlogServiceImpl implements IBlogService {

    @Override
    public void writeBlog() {
        System.out.println("Write Blog!");
    }

    @Override
    public void releaseBlog() {
        System.out.println("Release Blog!");
    }
}
