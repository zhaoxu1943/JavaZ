package com.practice.DataStructureAndAlgorithm.tencent.leetcode;

import javax.websocket.Decoder;
import javax.websocket.Encoder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * //给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * // 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * // 你可以假设 nums1 和 nums2 不会同时为空。
 * // 示例 1:
 * // nums1 = [1, 3]
 * //nums2 = [2]
 * //则中位数是 2.0
 * // 示例 2:
 * // nums1 = [1, 2]
 * //nums2 = [3, 4]
 * //则中位数是 (2 + 3)/2 = 2.5
 * // Related Topics 数组 二分查找 分治算法
 * @author zhaoxu
 * @className FindMedianSortedArrays_2
 * @projectName JavaConcentration
 * @date 2020/5/28 14:02
 */
public class FindMedianSortedArrays_2 {

    public static void main(String[] args) {
        //testcase 1
//        int[] nums1 = new int[] {1,3};
//        int[] nums2 = new int[] {2};

        //test case 2
        int[] nums1 = new int[] {1,2};
        int[] nums2 = new int[] {3,4};



        System.out.println(findMedianSortedArrays(nums1,nums2));
     }



    /**
     * 不考虑复杂度的话,简单的使用ArrayList即可,用Collections排下顺序
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double result = 0;
            List<Integer> integerList  = new ArrayList<>();
            for (int i :nums1) {
                integerList.add(i);
            }
            for (int j:nums2) {
                integerList.add(j);
            }
            Collections.sort(integerList);
            //判断元素数量奇数偶数
            //判断
            int arraySize = integerList.size();
            if(isEvenHighPerformance(arraySize)){
                int index = arraySize / 2;
                result = ((double)integerList.get(index)+(double)integerList.get(index -1))/2;
                return result;
            }else {
                return integerList.get((arraySize-1)/2);
            }
    }









    /**
     * 方法isEven
     * 如果是偶数,返回true
     * 如果是奇数,返回false
     * 通常的思路是一个数/2,看能不能整除
     * 除以2即无符号右移一位
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static boolean isEven (int num) {
        //单纯的判断奇数偶数
        return num % 2==0;
    }

    /**
     * 方法isEvenHigh
     * 除以2即无符号右移一位
     * 这里用位运算取低位,奇数的二进制低位一定是1
     * 偶数的二进制低位一定是0
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static boolean isEvenHighPerformance (Integer num) {
        return (num&1)==0;
    }

}
