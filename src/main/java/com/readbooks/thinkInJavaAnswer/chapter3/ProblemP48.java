package com.readbooks.thinkInJavaAnswer.chapter3;



/**
 * @author zhaoxu
 * @version 1.0
 * @className ProblemP48

 * @date 2020/1/7 14:33
 **/
public class ProblemP48 {
    public static void main(String[] args) {
        //8进制加0
        int int8 = 0122;
        //16进制加0x
        int intHex = 0x07FF;
        //自动装箱
        Integer m = int8;
        String s= Integer.toBinaryString(int8);
        String s1= Integer.toBinaryString(intHex);
        //自动拆箱
        int int2 =m;
        System.out.println(s);
        System.out.println(s1);
    }
}
