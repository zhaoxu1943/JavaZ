package com.practice.JavaSource;

import java.util.Objects;

/**
 * @ClassName eql
 * @Description 探究Object.equals()的源码
 * @Author zhaoxu
 * @Date 2019/11/8 11:40
 * @Version 1.0
 **/
public class JavaStringEquals {
    public static void main(String[] args) {
        String string = null;
        //确定有值再调用equals()
        //或者直接用常量.equals(变量)

        //如下,如果用一个空的String字符串调用equals()
        //会报NullPointerException
//        if (str.equals("123")){
//            System.out.println("123");
//        }
        //应该使用
        if ("123".equals(string)){
       }

        //推荐使用java.utils.Object
        //Object源码解读
        //return a||b的意思就是如果a是true则返回a,否则返回b
        //return a&&b的意思就是如果a是true就则返回b，否则返回a

        //return a?b:c的意思是a是true就返回b,否则返回c
//        public static boolean equals(Object a, Object b) {
//            return (a == b) || (a != null && a.equals(b));
//        }
        //首先return中||是a true返回a 否则b
        //而&&中a true返回b 否则a
        //这里首先执行了 == 如果相等那么返回true
        //否则就到了后面的短路与
        //首先判断 a是不是非空 如果为空后面不判断,直接返回false,也就不会产生空指针


        boolean b = Objects.equals(null,1);
        System.out.println(b);


        System.out.println(logicalJudgement(3,4,5));
    }

    public static int logicalJudgement(int i,int j,int k) {
      //  return a?b:c的意思是a是true就返回b,否则返回c
        return i<j?i:j;
    }


}
