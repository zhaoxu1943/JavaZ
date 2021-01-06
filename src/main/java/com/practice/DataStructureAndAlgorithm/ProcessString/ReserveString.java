package com.practice.DataStructureAndAlgorithm.ProcessString;


import java.util.Stack;

//字母异位判定相等
public class ReserveString {


    public static void main(String[] args) {

        String s = "abc";
        System.out.println(reserveStringByStringBuffer(s));
        System.out.println(reserveStringByStack(s));
        System.out.println(reserveStringBasic(s));
    }

    public static  String reserveStringByStringBuffer(String str1) {
        StringBuilder stringBuilder = new StringBuilder(str1);
        String reverseStr = stringBuilder.reverse().toString();
        return reverseStr;
    }

    public static String reserveStringByStack(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c:chars) {
            stack.push(c);
        }
        for (int i = 0; i <chars.length ; i++) {
            chars[i] = stack.pop();
        }
        return String.valueOf(chars);
    }

    public static String reserveStringBasic(String str) {
        char[] chars = str.toCharArray();
        int numsOfChars = chars.length-1;
        char[] charsNew = new char[chars.length];
        for (int i = numsOfChars; i >= 0 ; i--) {
            charsNew[numsOfChars-i]= chars[i];
        }
        return String.valueOf(charsNew);



    }



}
