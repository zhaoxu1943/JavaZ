package com.practice.JavaConcurrent;

/**
 * @ClassName shixian
 * @Description 类继承Thread实现多线程
 * @Author zhaoxu
 * @Date 2019/11/7 9:14
 * @Version 1.0
 **/
public class ExtendsThread extends Thread{


    //继承Thread类的方法

    @Override
    public void run() {
        super.run();
        System.out.println("继承Thread!");
    }
}
