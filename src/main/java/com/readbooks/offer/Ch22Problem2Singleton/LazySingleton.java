package com.readbooks.offer.Ch22Problem2Singleton;

/**
 * 懒汉
 * lazy
 * 延迟初始化
 * 双重检查的懒汉
 * 双重检查锁”（Double Check Lock，简称DCL）。
 * volatile 禁止指令重排序
 *  instance = new LazySingleton(); 并非原子操作
 *  经过指令重排后,可能会得到一个未初始化完成的对象
 *  核心:DCL+VOLATILE
 *  类锁是所有线程共享的锁，所以同一时刻，只能有一个线程使用加了锁的方法或方法体，不管是不是同一个实例。
 *
 *
 *  使用对象锁的情况，只有使用同一实例的线程才会受锁的影响，多个实例调用同一方法也不会受影响。
 *
 * 类锁是所有线程共享的锁，所以同一时刻，只能有一个线程使用加了锁的方法或方法体，不管是不是同一个实例。
 * @author zhaoxu
 * @className LazySingleton
 * @projectName JavaConcentration
 * @date 2020/10/27 19:09
 */
public class LazySingleton {



    /**
     * 经典私有构造
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private LazySingleton() {
    }

    /**
     * volatile 防止指令重排序
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static volatile LazySingleton instance;



    public static LazySingleton getInstance() {
        //第一次判定,此时两个线程均可进入
        if (instance == null) {
            //同步语句块保证只有一个线程进入,另一个在此阻塞
            //类锁是用于类的静态方法或者一个类的class对象上的。
            // 我们知道，类的对象实例可以有很多个，但是每个类只有一个class对象，
            // 所以不同对象实例的对象锁是互不干扰的，但是每个类只有一个类锁
            //类锁是所有线程共享的锁，所以同一时刻，只能有一个线程使用加了锁的方法或方法体，不管是不是同一个实例。
            synchronized (LazySingleton.class) {
                //当一个线程创建完毕后,第二个线程进入,发现不为空,则不创建,保证了线程安全
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
















}
