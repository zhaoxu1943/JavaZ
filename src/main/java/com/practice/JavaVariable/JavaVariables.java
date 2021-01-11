package com.practice.JavaVariable;

import com.concentration.entity.UserInfo;

/**
 * Java中定义方法的时候是可以定义参数
 * 比如Java中的main方法：String[] args就是参数。参数在程序语言中分为形式参数和实际参数。
 *
 * 抽象到更高层面,程序语言层面
 * 程序语言中分为形式参数和实际参数。
 * 形式参数：是在定义函数名和函数体的时候使用的参数,目的是用来接收调用该函数时传入的参数。
 * 实际参数：在调用有参函数时，主调函数和被调函数之间有数据传递关系。在主调函数中调用一个函数时，函数名后面括号中的参数称为“实际参数”。
 *  简单来说 实际参数是调用有参方法的时候真正传递的内容，而形式参数是用于接收实参内容的参数。
 *
 * 程序语言中是如何定义和区分值传递和引用传递的
 * 值传递（pass by value）是指在调用函数时将实际参数复制一份传递到函数中，
 * 这样在函数中如果对参数进行修改，将不会影响到实际参数。
 *
 * 引用传递（pass by reference）是指在调用函数时将实际参数的地址直接传递到函数中，
 * 那么在函数中对参数所进行的修改，将影响到实际参数。
 *
 * 简单来说就是实际参数复制 就是值传递
 * 而直接传递引用过去就是引用传递
 *
 *  通过概念我们也能知道，这里是把实际参数的引用的地址复制了一份，
 *  传递给了形式参数。所以，上面的参数其实是值传递，把实参对象引用的地址当做值传递给了形式参数。
 *
 *  也就是说
 *
 *  Java中的传递，是值传递(副本传递)，而这个值，实际上是对象的引用。是内存地址
 *  而不是对象本身
 *
 *  对象修改了是因为通过复制的这把钥匙(引用地址)打开了门,修改了内容(对象属性)
 *
 *  若进行对象的新建操作new,彻底改变了引用,就不会进行对象的修改了
 *
 * @ClassName JavaMemberVariable
 * @Description 值传递
 * @Author zhaoxu
 * @Date 2019/11/19 11:58
 * @Version 1.0
 **/
public class JavaVariables {

    public static int  memberVariable = 0;

    public static void main(String[] args) {

        //静态成员变量传入方法,改变了
        //静态成员变量根本就不涉及值传递 我服了
        addSelf();
        System.out.println("main方法中成员变量:"+memberVariable);
        //局部变量和String不变
        int localVariable = 0;
        addSelf(localVariable);
        System.out.println("main方法中局部变量:"+localVariable);
        //对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("z");
        updateObj(userInfo);
        System.out.println("main方法方法中对象名:"+userInfo.getUserName());


    }

    public static void addSelf() {
        for (int i = 0; i < 1000 ; i++) {
            memberVariable++;
        }
        System.out.println("静态变量处理方法中:"+memberVariable);

    }

    public static void addSelf(int localVariable) {
        for (int i = 0; i < 1000 ; i++) {
            localVariable++;
        }
        System.out.println("局部变量处理方法中:"+localVariable);
    }


    /**
     * 测试对象值传递
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void updateObj(UserInfo userInfo) {
        userInfo = new UserInfo();
        userInfo.setUserName("jusi");
        System.out.println("对象值传递处理方法中:"+userInfo.getUserName());
    }

}
