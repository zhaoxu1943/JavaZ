package com.readbooks.offer.Ch22Problem2Singleton;

/**
 * ch2 page32
 * 实现单例模式
 *
 * 饿汉
 * 三要素
 * 1.私有构造
 * 2.私有静态对象(类加载时初始化对象)
 * 3.公共静态方法(无需new对象,类名调用)
 *
 * 优点：简单粗暴、类加载的时候就初始化完成，线程安全；
 * 缺点：类加载的时候就已经完成初始化，如果该对象使用时机比较晚，或者始终没有用到，会造成不必要的内存资源浪费。
 * @author zhaoxu
 * @param
 * @return
 * @throws
 */

public class HungarySingleton {

    //私有构造
    private HungarySingleton() {
    }

    //私有静态对象
    private static HungarySingleton instance = new HungarySingleton();;

    /**
     * 公共静态方法,由其他类调用
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static HungarySingleton getInstance() {
        return instance;
    }
}
