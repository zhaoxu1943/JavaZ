package com.readbooks.TJAlgorithm.C4;

import java.util.Arrays;

/**
 * 二分查找也是一种优秀的DC算法
 * 体现了分而治之的思想
 * @author zhaoxu
 * @className BinarySearchDC
 * @projectName JavaConcentration
 * @date 2020/12/17 9:06
 */
public class BinarySearchDC {


    public static void main(String[] args) {
        int[] intArr  = new int[]{2,3,5,76,87,6764,5344543};
        System.out.println(binarySearch(intArr,1));
    }

  /**
   * 二分查找的基本模板
   *
   * <p>用极限情况判定区间开闭 情况1: 如果right = arr.length
   * 此时如果while条件是left<=right,那么会出现 mid=arr.length,数组下标越界的情况
   * 情况2: 如果right = arr.length-1; 那么会出现 mid=arr.length-1,不会越界
   *
   * <p>//终止条件:中点的值是target
   * //递归条件:每次缩小一半的范围
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private static int binarySearch(int[] arr, int searchElement) {
        int left = 0;
        int right = arr.length;
        //没有找到的中止条件,left=right,即已经找遍了数组
        //有两种可能
        //1.left逐渐增大找大的,直到越界
        //2.right逐渐减小到0,即left==right
        while(left<right) {
            int mid = left +(right-left)/2;
            //终止条件:中点的值是target
            //递归条件:每次缩小一半的范围
            if (arr[mid]==searchElement){
                //这里是正常返回的终止条件,找到了数字
                return mid;
            }else if(arr[mid]<searchElement){
                left=mid+1;
            }else if(arr[mid]>searchElement){
                right= mid-1;
            }
        }
        return -1;
    }







}
