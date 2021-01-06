package com.practice.DataStructureAndAlgorithm;


//基础数据类型和String
public class Caculater {

    public static void main(String[] args) {

        basicType();


    }


    public static void basicType(){
        //有符号整型储存的是补码,0x代表16进制,求补码FFFFFFFF的原码即可
        int i = 0xFFFFFFFF;
        //char Unicode范围 \u0000~\uFFFF
        char c = '\u0062';
        char c1 = '\uFFAF';
        //byte也是有符号整型,0表示8进制,1转化2进制为 001
        byte b = 01;
        //char类型转换为int,返回unicode码
        int i1 = 'a';
        //末尾加L为长整型,long范围巨大
        long l = 455555666666L;
        System.out.println(i);
        System.out.println(c1);
        System.out.println(b);
        System.out.println(i1);
        System.out.println(l);
    }






}
