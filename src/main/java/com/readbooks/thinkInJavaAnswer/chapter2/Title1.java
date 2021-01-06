package com.readbooks.thinkInJavaAnswer.chapter2;

/**
 * @author zhaoxu
 * @version 1.0
 * @className title1

 * @date 2019/12/9 12:58
 **/
public class Title1 {
    int i;
    char c;
    static String s =  "nihao";


    public static void main(String[] args) {
        //第一题,验证成员变量自动初始化,其中int初始化为0,char初始化为null
        Title1 t = new Title1();
        System.out.println(t.i);
        System.out.println(t.c);
        //第8题,static域只有一个实例
        Title1 title1 =new Title1();
        System.out.println(t.s==title1.s);
        //打印命令行参数
        for (String s:args) {
            System.out.println(s);
        }
        for (int i = 0; i <3 ; i++) {
            System.out.println(args[i]);
        }
        System.out.println(args.length);


    }

}
