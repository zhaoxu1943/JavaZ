package com.practice.JavaConcurrent;

/**
 * @ClassName Run
 * @Description 线程启动类,4种多线程的启动方法
 * @Author zhaoxu
 * @Date 2019/11/7 9:42
 * @Version 1.0
 **/
public class ThreadStart {

    public static void main(String[] args) {

        //事实上创建线程只有一种方式,
        //就是构造一个Thread类，这是创建线程的唯一方式。
        //第一种的Runnable
        //是实现Runnable接口的类的实例传入Thread实例中,即源码中的target
//        @Override
//        public void run() {
//            if (target != null) {
//                target.run();
//            }
//        }
        //这里就是执行RUNNABLE的run()方法






        //继承Thread方式
        Thread extendsThread = new ExtendsThread();
        extendsThread.start();
        try {
            synchronized (extendsThread){
                extendsThread.wait(5);
            }
            extendsThread.join();
            System.out.println("运行Thread结束!");
            //执行wait()之后,线程进入WAITTING状态
            //进入等待状态的线程,需要依靠其他的线程的通知才能返回RUNNABLE状态
            //而下面这两个加了时间参数,进入了TIMED WAITTING状态
            //超过时间就会返回到RUNNABLE状态
//            extendsThread.sleep(1000);
//            extendsThread.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





        //实现Runnable接口,传入Thread实例中并启动
        Runnable runnableThread = new RunnableThread();
        Thread thread = new Thread(runnableThread);
        thread.start();
        System.out.println("运行Runnable结束!");

        //下面是直接新建线程的两种写法


        //写法1,匿名内部类创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("直接新建线程写法1,同样是Runnable的实例传入Thread实例中");
            }
        }).start();

        //写法2
        Thread thread2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("同写法1相似 就是有了一个实例名 ");
            }
        });
        thread2.start();


        //写法3 lambda表达式

        new Thread (() -> System.out.println(Thread.currentThread().getName())).start();

    }
}
