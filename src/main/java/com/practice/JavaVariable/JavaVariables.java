package com.practice.JavaVariable;

/**
 * @ClassName JavaMemberVariable
 * @Description 值传递
 * @Author zhaoxu
 * @Date 2019/11/19 11:58
 * @Version 1.0
 **/
public class JavaVariables {

    public static int  memberVariable = 0;

    public static void main(String[] args) {
        //静态成员变量传入方法,改变了
        addSelf();
        System.out.println(memberVariable);
        //局部变量,不变
        int localVariable = 0;
        addSelf(localVariable);
        System.out.println(localVariable);

    }

    static void addSelf() {
        for (int i = 0; i < 1000 ; i++) {
            memberVariable++;
        }
    }

    static void addSelf(int localVariable) {
        for (int i = 0; i < 1000 ; i++) {
            localVariable++;
        }
    }

}
