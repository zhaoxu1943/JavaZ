package com.readbooks.thinkInJavaAnswer.chapter3;

import java.util.Random;

/**
 * @author zhaoxu
 * @version 1.0
 * @className probleminc3

 * @date 2019/12/14 0:00
 **/
public class ProblemInc3 {
    public static void main(String[] args) {
        //p44 Integer问题
//        Integer i1 = 47;
//        Integer i2 = 47;
//        System.out.println(i1==i2);
//        System.out.println(i1!=i2);
//        //在[-128-127中的Integer对象在常量池中]
//        Integer i3 = 128;
//        Integer i4 = 128;
//        System.out.println(i3==i4);
//        System.out.println(i3!=i4);

        System.out.println(coinsFace());

        int j=0;
        for (int i = 0; i <1000000; i++) {
            if (coinsFace().equals("正")){
                ++j;
            }
        }
        int k = 1000000-j;
        float f =j/10000;
        System.out.println("正面占比为 "+f+"%");

    }

     //方法一，随机取0,1
    public static String coinsFace() {
        Random random = new Random();
        int i=random.nextInt(2);
        if (i==0){
            return "正";
        }else {
            return "反";
        }
    }
    //方法二，随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
    public static String coinsFace1() {
        double b= Math.random();
        if (b<0.5){
            return "正";
        }else {
            return "反";
        }
    }


}
