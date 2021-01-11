package com.practice.DataStructureAndAlgorithm.tencent.leetcode;

import java.util.Arrays;

/**
 * @author zhaoxu
 * @className ReverseWords
 * @projectName JavaConcentration
 * @date 2021/1/11 9:56
 */
public class ReverseWords_557 {

  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";
    System.out.println(reverseWords(s));
  }






  public static String reverseWords(String s) {
    String[] words = s.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    for (String word : words) {
      // 转换为char数组后使用双指针
      char[] strArr = word.toCharArray();
      for (int leftIndex = 0, rightIndex = strArr.length - 1;
          leftIndex < rightIndex;
          ++leftIndex, --rightIndex) {
        char temp = strArr[leftIndex];
        strArr[leftIndex] = strArr[rightIndex];
        strArr[rightIndex] = temp;
      }
      //注意:字节数组转换为字符串 不能直接toString 否则显示的是数组的内存地址meng
      stringBuilder.append(new String(strArr)).append(" ");
    }
    return new String(stringBuilder).trim();
  }
}