package com.practice.JavaKeywords;

import com.practice.JavaBasicFeatures.JavaExtends.Animal;
import com.practice.JavaBasicFeatures.JavaWrapper.JavaWrapper;

import javax.lang.model.element.AnnotationMirror;

/**
 * @ClassName JavaThisAndSuper
 * @Description 研究this和super关键字
 * @Author zhaoxu
 * @Date 2019/11/21 11:24
 * @Version 1.0
 **/
public class JavaThisAndSuper extends Animal {

    public String name;
    public String type;

    //super()第一个用法:在子类继承父类时,,必须调用父类构造函数,
    //如果要调用父类有参构造函数,需要显式的写出super(参数1,参数2)
    //如果要调用父类无参构造,则自动隐式调用

    public JavaThisAndSuper(String animalType, int animalAge, String name, String type) {
        super(animalType, animalAge);
        this.name = name;
        this.type = type;
    }

    public JavaThisAndSuper(String name, String type) {
        //这里隐式的写了super(),不需要自己写
        //this()的第一个用法,成员变量和局部变量重名,指代成员变量
        this.name = name;
        this.type = type;
    }



    @Override
    public void eat() {
        System.out.println("这里重写的父类的eat方法!");
    }

    void combineSuperAndThis (){
        //this的第三个用法,在使用synchronized同步块的时候,this锁住的是实例方法的对象
        synchronized (this) {
            //super的第二个用法,调用父类的方法
            super.eat();
            //this()第二个用法,调用子类方法
            this.eat();
        }
    }

    public static void main(String[] args) {
        JavaThisAndSuper javaThisAndSuper = new JavaThisAndSuper("Animal",4,"cat","CAT");
        javaThisAndSuper.combineSuperAndThis();
        Animal animal =new Animal();
//        animal.sleep();
    }

// Object.java中的源码,这里的this指代调用这个方法的对象
    public boolean equals(Object obj) {
        return (this == obj);
    }


}
