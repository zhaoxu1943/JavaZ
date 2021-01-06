package com.practice.DataStructureAndAlgorithm;

import org.springframework.scheduling.concurrent.ForkJoinPoolFactoryBean;

import java.util.concurrent.*;

/**
 * @ClassName Fib
 * @Description 斐波那契数列
 * @Author zhaoxu
 * @Date 2019/12/4 11:28
 * @Version 1.0
 **/
public class Fibonacci extends RecursiveTask<Long>{

             final long n;

             Fibonacci(long n) { this.n = n; }

            public static void main(String[] args) throws InterruptedException{

                //使用普通线程池执行,并不会拆分,只会一个线程死磕 72s
//                long startTime = System.currentTimeMillis();
//                //自己建了一个CachedThreadPool
//                ThreadPoolExecutor executorService =new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.CallerRunsPolicy());
//                executorService.execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        for (int i = 0; i <50 ; i++) {
//                    System.out.println("第"+i+"个:"+ Fibonacci(i));
//                }
//                    }
//                });
//                executorService.shutdown();
//                //优雅的关闭，并允许关闭声明后新任务能提交，用awaitTermination()
//                executorService.awaitTermination(1,TimeUnit.HOURS);
//                long endTime = System.currentTimeMillis();
//                System.out.println(executorService.getLargestPoolSize());
//                System.out.println("运行时间:"+ (endTime-startTime) +"ms");



//                //普通方法执行,73s
//                long startTime = System.currentTimeMillis();
//                for (int i = 0; i <50 ; i++) {
//                    System.out.println("第"+i+"个:"+Fib(i));
//                }
//                long endTime = System.currentTimeMillis();
//                System.out.println("运行时间:"+ (endTime-startTime) +"ms");


                //由forkAndJoin理念我们可以将n>1的情况拆分成两部分,最后再相加
                //其他线程池公用一个任务队列,而forkjoinPool除了有一个公用的任务队列,每个线程都有一个对应的双端队列
                //一旦任务被分裂,就会放进自己的deque中
                //运行时间:423094ms....行吧,单线程用72s,你用420s,不过至少我看到了不同线程池的区别
                //work-stealing”可以平衡队列任务
                long startTime = System.currentTimeMillis();
                ForkJoinPool forkJoinPool = new ForkJoinPool();
                for (int i = 0; i <50; i++) {
                    try {
                        ForkJoinTask task = forkJoinPool.submit(new Fibonacci(i));
                        System.out.println("第"+i+"个:"+task.get());
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                long endTime = System.currentTimeMillis();
              System.out.println("运行时间:"+ (endTime-startTime) +"ms");

           }







    @Override
    protected Long compute() {
        if  (n <= 1) {
            return n;
        }
    Fibonacci f1 = new Fibonacci(n - 1);
     f1.fork();
     Fibonacci f2 = new Fibonacci(n - 2);
        f2.fork();
        //这里实现了分裂和汇总,和jdk源码不太一样
     return  f1.join()+f2.join();
    }





    //这是传统写法
                public static long Fib(int n) {
                    if (n <= 1) {
                        return n;
                    } else {
                        return Fib(n - 1) + Fib(n - 2);
                    }
                }

}

