package com.practice.designPattern.singletonPattern;

/**
 * @ClassName lazy
 * @Author zhaoxu
 * @Date 2019/10/23 10:43
 * @Version 1.0
 **/
public class SingletonLazy {

        //声明私有实例名
        //必须使用 volatile修饰单例变量,防止指令重排序
        private static volatile SingletonLazy instance;

        //构造方法私有
        private SingletonLazy() {}


        public static SingletonLazy getInstance() {
           //第一重检查,若两个线程进入 都可以过
            if (instance == null) {
                synchronized (SingletonLazy.class) {
                    //第二重,若第一个线程结束,不判断为空,第二个线程
                    //会继续创建线程
                    if (instance == null) {
                        instance = new SingletonLazy();
                    }
                }
            }
            return instance;
        }

    }


