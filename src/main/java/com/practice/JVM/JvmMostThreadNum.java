package com.practice.JVM;

import java.util.concurrent.CountDownLatch;

/**
 * JVM最多线程数
 * @author zhaoxu
 * @className JvmMostThreadNum
 * @projectName JavaConcentration
 * @date 2020/7/13 17:53
 */
public class JvmMostThreadNum {

    public static void main(String[] args) {

        for (int i = 0;; i++) {
            System.out.println("i = " + i);
            new Thread(new HoldThread()).start();
        }
    }

}

class HoldThread extends Thread {
    CountDownLatch cdl = new CountDownLatch(1);

    public HoldThread() {
        this.setDaemon(true);
    }

    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
    }
}

