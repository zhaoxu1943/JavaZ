package com.practice.JavaBasicFeatures.JavaGeneric;

/**
 * 学习方法泛型
 * @author zhaoxu
 * @className MethodGeneric
 * @projectName JavaConcentration
 * @date 2020/6/10 14:17
 */
public class MethodGeneric {

    public static void main(String[] args) {
        print(1);
        print("123");
        print(22222222222222L);

    }

    private static  <T>  void print(T t) {
        System.out.println(t);
    }

}
