package com.practice.JavaSource;

/**
 * @ClassName JavaClass
 * @Description 探究Class.java,尼玛3000多行,Object才500行
 * {@link Class}
 *
 * @Author zhaoxu
 * @Date 11/27/2019 5:12 PM
 * @Version 1.0
 **/
public class JavaClass {
    public static void main(String[] args) {
        //首先看它如何打印一个对象的className
        JavaClass javaClass =new JavaClass();
        javaClass.printClassName(javaClass);
        System.out.println("The name of class JavaClass is: "+JavaClass.class.getName());

        //Class类有一个私有的构造函数,只有JVM可以new他的对象,这样是不可以的
        //Class class = new Class();

    }

    //From Class.java
    void printClassName(Object obj) {
          System.out.println("The class of " + obj +
                                          " is " + obj.getClass().getName());
      }
}
