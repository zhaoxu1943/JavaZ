package com.practice.JavaConcurrent.ThreadPool;

/**
 * @ClassName TenTask
 * @Description 循环新建10个线程
 * @Author zhaoxu
 * @Date 2019/11/26 0:45
 * @Version 1.0
 **/
public class TenTask {


    //java中的线程和系统中的线程一一对应
    //如果不使用线程池,如果每个任务都创建一个线程会带来哪些问题：
    //
    //第一点，反复创建线程系统开销比较大，每个线程创建和销毁都需要时间，如果任务比较简单，那么就有可能导致创建和销毁线程消耗的资源比线程执行任务本身消耗的资源还要大。
    //
    //第二点，过多的线程会占用过多的内存等资源，还会带来过多的上下文切换，同时还会导致系统不稳定。
    //线程池有两个解决思路。
    //
    //首先，针对反复创建线程开销大的问题，线程池用一些固定的线程一直保持工作状态并反复执行任务。
    //
    //其次，针对过多线程占用太多内存资源的问题，解决思路更直接，线程池会根据需要创建线程，控制线程的总数量，避免占用过多内存资源。



    public  static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();
        }



        //Lambda写法
//        for (int i = 0; i < 10; i++) {
//            new Thread(()-> System.out.println(Thread.currentThread().getId())).start();
//        }
    }

}
