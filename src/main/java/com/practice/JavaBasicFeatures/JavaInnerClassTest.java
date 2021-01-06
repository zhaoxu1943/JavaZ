package com.practice.JavaBasicFeatures;

/**
 * @ClassName JavaInnerClassTest
 * @Description Java内部类的测试类，尝试调用内部类等操作
 * @Author zhaoxu
 * @Date 2019/11/21 21:54
 * @Version 1.0
 **/
public class JavaInnerClassTest {
    public static void main(String[] args) {
        //在外部类中尝试调用其他类的public静态内部类
        //在这个过程中,另一个类中的静态内部类调用了外部类的私有属性
        //当静态内部类改为private时，或内部类中的方法改为private时都无法使用
        JavaInnerClass.StaticInner staticInner =new JavaInnerClass.StaticInner();
        staticInner.print();

        //调用成员内部类,必须先new一个外部类的对象
        JavaInnerClass javaInnerClass =new JavaInnerClass();
        JavaInnerClass.MemberInner memberInner =javaInnerClass.new MemberInner();
        memberInner.print();

        javaInnerClass.test(1);
    }
}
