package com.practice.JavaConcurrent.JavaThreadSafe;

/**
 * @ClassName WrongResult
 * @Description 线程安全问题第一类,访问共享变量与共享资源,多线程导致的值错误问题
 * 即这些信息是共享的,不仅会被一个线程访问,还会被多个线程同时访问,可能在并发读写产生线程安全问题
 * @Author zhaoxu
 * @Date 2019/11/19 11:35
 * @Version 1.0
 **/
public class WrongResult {

    //静态变量：线程非安全。
    //
    //静态变量即类变量，位于方法区，为所有对象共享，共享一份内存，一旦静态变量被修改，其他对象均对修改可见，故线程非安全。
    //也就是说一个线程修改了,其他地方的线程对修改可见,线程不安全
    //
    //
    //实例变量：单例模式（只有一个对象实例存在）线程非安全，非单例线程安全。
    //
    //实例变量为对象实例私有，在虚拟机的堆中分配，若在系统中只存在一个此对象的实例，在多线程环境下
    // “犹如”静态变量那样，被某个线程修改后，其他线程对修改均可见，故线程非安全；
    // 如果每个线程执行都是在不同的对象中，那对象与对象之间的实例变量的修改将互不影响，故线程安全。
    //
    //
    //
    //局部变量：线程安全。
    //
    //每个线程执行时将会把局部变量放在各自栈帧的工作内存中，线程间不共享，故不存在线程安全问题。


    //如静态变量,谁都能改,改完修改全可见
    private static volatile int s = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                add();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                add();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        //由于非线程安全,i++的操作也非原子性操作,s的结果每次都是随机的
        System.out.println(s);


    }

    //
    public synchronized static void add() {
        for (int i =0 ;i<100000;i++) {
                s++;
        }
    }


    //锁住对象不可以
//    public  static void add() {
//        Integer integerS = s;
//        synchronized (integerS) {
//            for (int i =0 ;i<100000;i++) {
//                s++;
//            }
//        }
//    }

}
