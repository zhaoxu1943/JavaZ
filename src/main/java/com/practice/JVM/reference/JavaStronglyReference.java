package com.practice.JVM.reference;

/**
 * @author zhaoxu
 * @version 1.0
 * @className JavaStronglyReference
 * @description 探究强引用
 *
 * VM args -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -XX:+PrintGCTimeStamps
 * @date 2019/12/30 15:33
 **/
public class JavaStronglyReference {


    public static void main(String[] args) {
        //强引用是最普遍使用的引用,如果一个对象具有强引用,GC绝对不会回收
        JavaStronglyReference javaStronglyReference = new JavaStronglyReference();
        //当内存空间不足时.JVM宁愿抛出OOM,使程序异常终止,也不会随意回收具有强引用的对象来解决

        //当强引在方法内部,方法执行后栈帧出栈,引用消失,不用显式的赋予null

        //用对象为全局变量,需要弱化从而使GC回收
        javaStronglyReference = null;

    }

    public void print(){
        System.out.println("123");
    }

}
