package com.practice.JavaBasicFeatures;

/**
 *
 * Return意味着程序的终止
 *
 * @author zhaoxu
 * @className JavaReturn
 * @projectName JavaConcentration
 * @date 2020/12/21 16:48
 */
public class JavaReturn {

  public static void main(String[] args) {
      testReturn(2);
  }


  public static void testReturn(int  flag){
      int total = 0;

      if (flag ==1){
          total =3;
          System.out.println(total);
          return;
      }

      total =5;
    System.out.println(total);
  }

}
