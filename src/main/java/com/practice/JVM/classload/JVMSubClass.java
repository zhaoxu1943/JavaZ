package com.practice.JVM.classload;

/**
 * @author zhaoxu
 * @version 1.0
 * @className JVMSubClass

 * @date 2020/1/8 7:57
 **/
public class JVMSubClass extends JVMSuperClass {

    static{
        System.out.println("subclass init!");
    }
}
