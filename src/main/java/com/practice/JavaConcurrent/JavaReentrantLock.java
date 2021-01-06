package com.practice.JavaConcurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhaoxu
 * @className JavaReentrantLock
 * @projectName JavaConcentration

 * @date 3/4/2020 9:58 PM
 */
public class JavaReentrantLock  {

    public static void main(String[] args) {


        Lock lock = new ReentrantLock();

        ReadWriteLock lock1 = new ReentrantReadWriteLock();

        try {
            lock = new ReentrantLock();
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }



    }
}
