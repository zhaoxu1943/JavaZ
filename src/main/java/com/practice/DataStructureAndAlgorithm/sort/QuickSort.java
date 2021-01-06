package com.practice.DataStructureAndAlgorithm.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Divide and Conquer D&C 分而治之
 *  越看越有道理啊...wdnmd
 * <p>任意选取一个元素
 *
 * @author zhaoxu
 * @className QuickSort
 * @projectName JavaConcentration
 * @date 2020/12/16 9:08
 */
public class QuickSort {

  public static void main(String[] args) {
    Integer[] arr = {321,322,32,55454,54,5,2,433,4234,23,43,24,32,43243243,321};
    List<Integer> integerList =  Lists.newArrayList(arr);
    integerList= quickSort(integerList);

    for (int i :integerList ) {
      System.out.println(i);
    }



  }

  /**
   * 基线条件 数组小于2
   * 递归如同多米诺骨牌
   * 而基线条件就是第一块骨牌
   * 在基线条件未触发时
   * 所有的递归调用都会保持
   * 直到第一块骨牌倒下
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public static List<Integer> quickSort(List<Integer> list) {
    List<Integer> result= Lists.newArrayList();
    // 基线条件
    // 即数组为空,或者数组只有一个元素,无需排序直接返回原数组
    if (list.size() < 2) {
      return list;
    } else {
      // 选取基准值
      int pivot = list.get(0);
      List<Integer> leftPivot = new ArrayList<>();
      List<Integer> rightPivot = new ArrayList<>();
      //此时是n的复杂度
      for (int i = 1; i < list.size(); i++) {
        if (list.get(i)<pivot){
          leftPivot.add(list.get(i));
      }else {
          rightPivot.add(list.get(i));
        }
      }
      //再递归logN次,即可覆盖全列表
      leftPivot = quickSort(leftPivot);
      rightPivot = quickSort(rightPivot);
      result.addAll(leftPivot);
      result.add(pivot);
      result.addAll(rightPivot);
    }
    return result;
  }
//
//  /**
//   * 基线条件 数组小于等于2
//   *
//   * @author zhaoxu
//   * @param
//   * @return
//   * @throws
//   */
//  public static int[] quickSort(int[] arr) {}
}
