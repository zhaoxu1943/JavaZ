package com.practice.JavaBasicDataType;

import java.util.Date;

/**
 * @author zhaoxu
 */
public class AutoBoxingAndUnboxing {



    void autoBoxing () {
        //自动装箱 基础类型转化为包装类
        //调用了包装类中的valueOf()方法

        //表面上,直接装成包装类
        Integer integer = 10;

        //实际上进行了,使用了包装类的valueOf方法
        Integer i =  Integer.valueOf(10);
        Character c = Character.valueOf('c');
        //进行拆箱
        char x = c;
        char x1 = c.charValue();
        //这里同理可以引申出String字符串转Integer
        String string = "123";
        Integer integer1 = Integer.valueOf(string);
        //valueOf方法返回的是Integer对象,这里可以直接赋值给int i1,那么是进行了一次自动拆箱
        int i1 = Integer.valueOf(string);

        //那么int如何转化为String呢
        int i2 = 32;
        String string2 = String.valueOf(i2);

    }

    static void autoUnboxing () {
        Integer integer = 10;

        //自动拆箱 包装类转化为基础数据类型
        //直接将包装类转化为基础数据类型
        int i = integer;

        //其实使用了包装类的xxxvalue()方法,各种float,doubleValue都有,想转啥转啥
        int i1 = integer.intValue();


    }


    public static void main(String[] args) {
        Integer integer =10;

//
//        System.out.println(new Date());
//        System.getProperties().list(System.out);
//        System.out.println(System.getProperty("user.name"));
//        System.out.println(System.getProperty("java.library.path"));
    }
}
