package com.practice.JVM;

/**
 * 写个死锁 单线程你写啥锁呢 我服了 没得锁
 *
 * @author zhaoxu
 * @className ZDeakLock
 * @projectName JavaConcentration
 * @date 2021/1/14 14:08
 */
public class ZDeadLock {

  private static final Object lock1 = new Object();

  private static final Object lock2 = new Object();

  public static void main(String[] args) {
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                getLock1();
              }
            })
        .start();

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                getLock2();
              }
            })
        .start();
  }

  public static void getLock2() {
    synchronized (lock1) {
      System.out.println("持有lock1,等待获取lock2..");
      synchronized (lock2) {
        System.out.println("获取到了lock2");
      }
    }
  }

  public static void getLock1() {
    synchronized (lock2) {
      System.out.println("持有lock2,等待获取lock1..");
      synchronized (lock1) {
        System.out.println("获取到了lock1");
      }
    }
  }
}
