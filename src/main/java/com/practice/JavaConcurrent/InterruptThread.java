package com.practice.JavaConcurrent;

/**
 * @ClassName InterruptThread
 * @Description 线程的中断
 * @Author zhaoxu
 * @Date 2019/11/18 14:36
 * @Version 1.0
 **/
public class InterruptThread implements Runnable {

    //java中安全停止线程使用Interrupt
    //通知体系

    //每个线程都有中断标记位,当执行thread.interrupt之后,中断标记位为true


    @Override
    public void run() {
        int count = 0;
        try {
            while (!Thread.currentThread().isInterrupted()&&count<1000) {
                System.out.println("count = "+ count++);
                //2s执行一次,如果子线程的休眠时间大于main的,且中途要停止,那么执行线程的interrupt也会中断,并抛出InterruptedException异常,清除中断信号
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }


    //checked Exception 编译器要检查这类异常,要开发者去处理
    //Unchecked Exception 自己代码的逻辑问题 如数组下边越界等 编译器不会要求你去处理
    //run方法中无法抛出checked Exception


    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new InterruptThread();
        Thread thread = new Thread(runnable);
        thread.start();
        thread.wait();
        //sleep是静态方法,通过类名+函数名调用,这里的sleep是让main 方法的主线程sleep5s后恢复
        //注意：在哪个线程里面调用sleep()方法就阻塞哪个线程。在main中调用就阻塞main 在线程类中调用就阻塞线程
        //sleep()方法是Thread类的静态方法，如果调用线程对象.sleep()方法并不是该线程就休眠，反正在哪一个线程里面执行了sleep()方法哪一个线程就休眠。
        //线程睡眠到期自动苏醒，并返回到可运行状态（就绪），不是运行状态。

        //3种方法让main进入等待状态
        //1 Thread.sleep() Thread类中的静态方法 是当前线程阻塞
        Thread.sleep(50);
        //2 LockSupport工具 阻塞当前线程 单位纳秒
        //LockSupport.parkNanos(10000000000L);
        //3 Thread类的join方法 等待线程执行完毕
        ///thread.join();
        thread.interrupt();
    }


    //在方法中抛出异常InterruptedException的好处是可以层层传递到顶层,保证处理
    public static void mainAnother () {
        String[] strings = {"1","2"} ;
        int[] ints = new int[5];
        try {
            InterruptThread.main(strings);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
