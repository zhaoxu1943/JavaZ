package com.test.genshuixue;

import java.util.Stack;

/**
 * 反转整数值 输入一个整数，反转输出 输入 in = 12345 输出 out = 54321 ClassName Interview Description Create by zhaoxu
 * Date 2021/1/22 19:48
 */
public class Interview_reverseInt {

  public static void main(String[] args) {
      int i = 12345;
      String s = String.valueOf(i);
      char[] chars = s.toCharArray();

      int left = 0;
      int right = chars.length-1;
      while(left<right){
          char temp;
          temp = chars[left];
          chars[left] = chars[right];
          chars[right] = temp;
          left++;
          right--;
      }
      String resultStr = new String(chars);

    System.out.print(Integer.valueOf(resultStr));
  }
}
