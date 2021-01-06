package com.practice.designPattern.singletonPattern;

/**
 * @ClassName hungry
 * @Author zhaoxu
 * @Date 2019/10/23 10:40
 * @Version 1.0
 **/
public class SingletonHungry {

    //类初始化时new
    private final static SingletonHungry INSTANCE = new SingletonHungry();

    //构造方法私有
    private SingletonHungry(){}

    //提供方法返回私有对象
    public static SingletonHungry getInstance(){
        return INSTANCE;
    }



}
