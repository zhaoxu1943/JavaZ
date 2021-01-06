package com.practice.JVM.classload;

/**
 * @author zhaoxu
 * @version 1.0
 * @className JVMTest
 * @description 探究类的被动初始化
 * 1.当用子类调用父类类变量,只会引发父类的初始化
 * 2.数组定义类,不会导致类初始化
 * 3.对类常量(final)的引用,无法使类初始化
 * @date 2020/1/8 7:57
 **/
public class JVMTest {
    public static void main(String[] args) {
        //被动使用1,子类调用父类类变量
        //System.out.println(JVMSubClass.value);
        //数组定义类,不会导致类初始化
        //JVMSuperClass[] jsc = new JVMSuperClass[10];
        //对类常量(final)的引用,无法使类初始化
        System.out.println(JVMSuperClass.string);


    }
}
