package com.practice.JavaConcurrent.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaoxu
 * @className MyCachedThreadPool
 * @projectName JavaConcentration

 * @date 3/4/2020 5:08 PM
 */
public class MyCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <1000 ; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
