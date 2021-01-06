package com.practice.JavaBasicFeatures.JavaException;


import com.practice.JavaBasicFeatures.JavaEqualsAndHashcode.EqualsAndHashcode;

// try catch问题 finally总会在 try的return前执行
// 总结：
//
//1、finally中的代码总会被执行。
//
//2、当try、catch中有return时，也会执行finally。return的时候，要注意返回值的类型，是否受到finally中代码的影响。
//
//3、finally中有return时，会直接在finally中退出，导致try、catch中的return失效。
public class OrderOfTryCatchFinally {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
//3
        System.out.println(test111());

        //a、对于基本类型或常量(如String) finally里即使修改了，也不会影响返回结果。
        //
        //b、如果是对象类型，finally里修改了对象 是影响返回结果的。（因为复杂对象传递的是指针 指针指向的内存区域是一样的。）
        //0
       // System.out.println(test());
//1
       // System.out.println(testobject().getAge());
    }



     public static int test111 () {
        int i= 0;
        try {
          return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }


    public static int test() {
        int t = 0;
        try {
            return t;
        } finally {
             t=t+1;
        }
    }


    public static EqualsAndHashcode testobject() {
        EqualsAndHashcode t = new EqualsAndHashcode();
        t.age = 0;
        try {
            return t;
        } finally {
            t.age++;
        }
    }





}
