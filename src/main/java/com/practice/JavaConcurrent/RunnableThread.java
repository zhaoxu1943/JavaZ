package com.practice.JavaConcurrent;

/**
 * @ClassName shixian1
 * @Description 实现Runnable接口实现多线程
 * @Author zhaoxu
 * @Date 2019/11/7 9:27
 * @Version 1.0
 **/
public class RunnableThread implements Runnable {


    // 一般使用实现 Runnable 接口实现

    @Override
    public void run() {
        System.out.println("实现Runnable接口!");
    }
}
