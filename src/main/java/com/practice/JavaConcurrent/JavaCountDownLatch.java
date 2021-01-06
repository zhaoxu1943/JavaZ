package com.practice.JavaConcurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatchDemo
 * CountDownLatch是package java.util.concurrent下的 ,从jdk1.5引入的并发流程控制工具类
 * 采用AQS
 * 核心思想:等到一个设定的倒数值到达之后,才能出发.
 * 即坐满发车
 *
 * 一等多/多等一,可以分别使用,可以结合使用,用于更复杂的业务场景
 * CountDownLatch,不可重新倒数,是一次性的
 * 重用的话选择CyclicBarrier
 * @author zhaoxu
 * @className JavaCountDownLatch
 * @projectName JavaConcentration
 * @date 2020/6/11 11:49
 */
public class JavaCountDownLatch {
    public static void main(String[] args)  throws InterruptedException{
        //一等多
     //   oneWaitN();
        //多等一
        nWaitOne();


    }

    /**
     * 1等多,main主线程等各个子线程执行完毕后
     * 主线程开始执行
     * 模型:大巴坐满发车
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void oneWaitN() throws InterruptedException {
        //传入倒数的值
        CountDownLatch countDownLatch = new CountDownLatch(8);

        //场景一,如所有创建连接,初始化变量的工作都执行完毕后,main主线程才开始执行
        //创建一个5个线程的固定线程池
        ExecutorService service =  Executors.newFixedThreadPool(5);
        //不断向其中加入任务

        //for循环创建5个任务
        for (int i = 0; i < 8; i++) {
            final int num = i+1;
            //任务,匿名内部类
            Runnable runnable = () -> {
                try {
                    Thread.sleep((long) (Math.random()*10000));
                    System.out.println(num+"号运动员完成了比赛");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    //最终倒数器减一
                    countDownLatch.countDown();
                }
            };
            //在循环中提交任务
            service.submit(runnable);
        }
        //主线程执行
        System.out.println("等8个运动员都跑完...");
        countDownLatch.await();
        System.out.println("都跑完啦,比赛结束");

    }



    /**
     * 多等一
     * 多个线程等待某一个线程的信号,同时开始执行
     * 模型:运动员等待裁判信号起跑
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void nWaitOne() throws InterruptedException {
        //传入倒数的值
        CountDownLatch countDownLatch = new CountDownLatch(1);


        //场景二,所有线程等待主线程的执行信号,一声枪响,大家同时起跑
        //还是创建一个5个线程的固定线程池(运动员就位,开始等待)
        ExecutorService service =  Executors.newFixedThreadPool(5);
        //不断向其中加入任务

        //for循环创建5个任务
        for (int i = 0; i < 8; i++) {
            final int num = i+1;
            //任务,匿名内部类
            Runnable runnable = () -> {
                try {
                    //先等待
                    countDownLatch.await();
                    System.out.println(num+"出发了!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            //在循环中提交任务
            service.submit(runnable);
        }
        //主线程执行
        //主线程打印
        System.out.println("大家有5s的准备时间");
        //等待5s执行countdown
        countDownLatch.await(5, TimeUnit.SECONDS);
        countDownLatch.countDown();
    }
}
