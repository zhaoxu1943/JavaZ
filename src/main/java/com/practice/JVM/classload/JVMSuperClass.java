package com.practice.JVM.classload;

/**
 * @author zhaoxu
 * @version 1.0
 * @className JVMSuperClass

 * @date 2020/1/8 7:57
 **/
public class JVMSuperClass {

    public static int value = 2;
    public final static String string = "世界人民大团结!";
    static{
        System.out.println("superclass init!");
    }
}
