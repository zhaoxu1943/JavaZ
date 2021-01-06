package com.practice.designPattern.proxyPattern;

//目标接口
//the most important thing, proxy class and origin class
//needs extending the same interface
public interface IBlogService {

    //接口中定义方法
    void writeBlog();

    void releaseBlog();

}

