package com.practice.DataStructureAndAlgorithm.tencent.leetcode;

/**
 * @author zhaoxu
 * @className ReverseString_344
 * @projectName JavaConcentration
 * @date 2021/1/11 9:29
 */
public class ReverseString_344 {

  public static void main(String[] args) {
    //
  }


    public void reverseString(char[] s) {
        //最朴素办法 借助O(1)  作为中间temp值
        //保存中间变量
        //双指针法修改,直到指针相遇
        int leftIndex = 0;
        int rightIndex = s.length-1;
        //这里写成if是单次循环//
        //写成while 才能无限循环
        while (rightIndex>leftIndex){
            char temp;
            temp = s[leftIndex];
            s[leftIndex] = s[rightIndex];
            s[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }

}
