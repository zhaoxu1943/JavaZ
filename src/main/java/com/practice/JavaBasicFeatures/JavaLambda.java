package com.practice.JavaBasicFeatures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName JavaLambda
 * @Description 语法糖（Syntactic sugar），也译为糖衣语法，是由英国计算机科学家彼得·约翰·兰达（Peter J. Landin）发明的一个术语，
 * 指计算机语言中添加的某种语法，这种语法对语言的功能并没有影响，但是更方便程序员使用。
 * 通常来说使用语法糖能够增加程序的可读性，从而减少程序代码出错的机会。
 *本篇研究lambda的语法
 *
 *
 * Java Lambda 表达式以函数式接口为基础。
 * 什么是函数式接口（FunctionalInterface）？ 简单说来就是只有一个方法（函数）的接口，这类接口的目的是为了一个单一的操作，
 * 也就相当于一个单一的函数了。常见的接口如：Runnable, Comparator 都是函数式接口，并且都标注了注解 @FunctionalInterface 。
 *
 * Lambda表达式
 *
 *  (parameters) -> expression
 *
 *  (parameters) -> { statements; }
 *
 * (parameters)类似方法中的形参列表
 * -> 被用于
 *
 * Lambda表达式所使用的外部变量不能是可变的局部变量
 * (也就是说它只能接受成员变量,final的局部变量和参数)
 *
 * Lambda表达式是运行在一个独立的子线程中,
 * 当这个线程运行时,它实际上拿到的是一个原始变量的副本(一个拷贝)
 *
 * 由于线程相隔 故主线程中的循环值i
 * @Author zhaoxu
 * @Date 2019/11/21 18:39
 * @Version 1.0
 **/
public class JavaLambda {

    public static void main(String[] args) {
         //之前的写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("没有lambda之前,我们new一个线程,用到了实现Runnable接口的匿名类"+Thread.currentThread().getId());
            }
        }).start();

        //lambda表达式
        new Thread(()-> System.out.println(Thread.currentThread().getState())).start();

        //
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        new Thread(runnable).start();


        Integer[] a = {1,4,5,1,2,5,1};

        //普通的从小到大排列
    //        Arrays.sort(a);
    //        for (int i:a) {
    //            System.out.print(i);
    //        }
        Arrays.sort(a, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                }
        );
        for (int i:a) {
            System.out.print(i);
        }

        //lambda
        Integer[] b = {1, 8, 3, 9, 2, 0, 5};
        Arrays.sort(b, (o1, o2) -> o1 - o2);

        for (int i:b) {
            System.out.print(i);
        }


    }


}
