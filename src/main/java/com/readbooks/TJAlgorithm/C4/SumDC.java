package com.readbooks.TJAlgorithm.C4;

import java.util.Arrays;

/**
 * 对于数组sum的D&C算法
 * 对于数组的递归基线条件一般是数组包含0或1个元素
 * @author zhaoxu
 * @className SumDC
 * @projectName JavaConcentration
 * @date 2020/12/16 9:25
 */
public class SumDC {

  public static void main(String[] args) {
    int[] intArr  = new int[]{1,2,32,32,32,3};
    System.out.println(getSum(intArr));
  }


  /**
   * sum的D&C算法
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private static int getSum(int[] arr) {
     //先点明基线条件
      if (arr.length==0) {
          return 0;
      } else{
          return arr[0]+getSum(Arrays.copyOfRange(arr,1,arr.length));
      }
  }












}
