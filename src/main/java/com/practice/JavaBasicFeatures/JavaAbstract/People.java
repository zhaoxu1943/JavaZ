package com.practice.JavaBasicFeatures.JavaAbstract;


public abstract class People {
//抽象类 是抽取不同事物共有方法和属性,构成公共的父类
    //抽象类不能实例化,必须继承来使用


    protected String name;
    protected String type;

    public People(String name, String type) {
        this.name = name ;
        this.type= type;
        System.out.printf("调用抽象类People的有参构造.");
    }

    //抽象方法,必须为public/protected 否则无法被子类@override
    //同接口中的 void commit(); 只有方法名,没有body
    //子类继承父类必须重写其抽象方法
    //如果子类继承后没有重写父类的abstract方法,那么子类必须也声明为抽象类
    public abstract void LifeStyles();

    //普通方法
    public void DrinkMilk () {
        System.out.printf(name+"need drink milk everyday!");
    }

}
