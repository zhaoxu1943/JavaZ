package com.readbooks.offer;

import java.util.Arrays;

/**
 * 替换空格
 * 实现一个函数 将字符串中的每个空格替换成 %20 例如 we are happy 替换为 we%20are%20happy
 *
 * 还可以看例题88,合并两个有序数组,也是从后往前双指针法
 * 举一反三:在合并两个数组或字符串时,如果从前往后往往需要复制多次
 * 考虑从后往前遍历,可以减少复制的次数
 * @author zhaoxu
 * @className ReplaceBlank
 * @projectName JavaConcentration
 * @date 2021/1/4 9:49
 */
public class ReplaceBlank {


    /**
     * 测试方法
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
  public static void main(String[] args) {
    String str = "     ";
    System.out.println(replaceBlank1(str));
  }

  /**
   * 原生API 工作中使用
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public static String replaceBlank(String s) {
      return s.replace(" ","%20");
  }

    /**
     * 手动编写处理串
     * 遍历一次即可,插入新的数组
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static String replaceBlank1(String s) {
        char[] strCharArr = s.toCharArray();
        //最多每个都替换,故*3
        char[] replaceBlankCharArr = new char[strCharArr.length*3];
        char blankChar = ' ';
        int newArrIndex = 0;
        for (char c : strCharArr) {
            if (blankChar == c) {
                //当遇到空格
                replaceBlankCharArr[newArrIndex] = '%';
                replaceBlankCharArr[++newArrIndex] = '2';
                replaceBlankCharArr[++newArrIndex] = '0';
                //再次使索引++,以方便下一次插入
                newArrIndex++;
            } else {
                //未遇到空格
                replaceBlankCharArr[newArrIndex] = c;
                newArrIndex++;
            }
        }
        return new String(replaceBlankCharArr,0,newArrIndex);
    }





}
