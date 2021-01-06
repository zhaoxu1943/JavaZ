package com.practice.DataStructureAndAlgorithm.sort;

import com.concentration.util.ZxUtil;

/**
 * 选择排序- from 算法图解
 * 是一种 不太快的,但思路很简单的算法
 * 例如:在你的电脑中存在一个歌单,并且有歌单的每一首歌曲的播放次数
 * 思路为:遍历这个数组,找出最大,并存在另一个新的数组中
 * 时间复杂度o(n^2)
 * 空间复杂度O(n)
 * @author zhaoxu
 * @className ChooseSort
 * @projectName JavaConcentration
 * @date 2020/10/25 21:26
 */
public class ChooseSort{



    public static void main(String[] args) {
        int[] arr = new int[]{0,32,123,4343,43,43,4,3,43,543,1,23,21,312};
        //测试寻找最大值索引
        int maxIndex = findMaxIndex(arr);
        //测试寻找最大值
        int max = findMaxIndex(arr);
        //测试寻找最小值索引
        int minIndex = findMinIndex(arr);
        //测试寻找最小值
        int min = findMin(arr);
        ZxUtil.printArray(arr);
        System.out.println("---------choose sort!---------");



        int[] arrSorted =chooseSort(arr);
        ZxUtil.printArray(arrSorted);
    }



    /**
     * 选择排序
     *
     * @param arr
     * @return 有序数组int[]
     * @author zhaoxu
     */
    public static int[] chooseSort(int[] arr) {
        //new arr, has the same size with
        int[] result = new int[arr.length];

        for (int i = 0; i <arr.length ; i++) {
            int maxIndex = findMaxIndex(arr);
            result[i] = arr[maxIndex];
            //将值清空
            arr[maxIndex] = 0;
        }
        return result;
    }



    /**

    /**
     * 找到数组中最大的值
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static int findMaxIndex(int[] arr) {
        if (arr.length<2) {
            throw new IllegalStateException("数组没有元素,或只有1个元素,无法排序!");
        }else {
            int size = arr.length;
            //假设第一个数就是最大数字,或者说以其为基准
            int maxIndex = 0;
            int max = arr[0];
            //遍历,从index为1 开始
            //消耗空间复杂度O(1),存放index
            for (int i = 1; i <size ; i++) {
                if (arr[i] > max) {
                    //重新选择小的为基准
                    max = arr[i];
                    maxIndex=i;
                }

            }return maxIndex;
        }}


    /**
     * 找到数组中最大的值
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static int findMax(int[] arr) {
        if (arr.length<2) {
            throw new IllegalStateException("数组没有元素,或只有1个元素,无法排序!");
        }else {
            int size = arr.length;
            //假设第一个数就是最大数字,或者说以其为基准
            int maxIndex = 0;
            int max = arr[0];
            //第一次遍历,从index为1 开始
            //消耗空间复杂度O(1),存放index
            for (int i = 1; i <size ; i++) {
                if (arr[i] > max) {
                    //重新选择小的为基准
                    max = arr[i];
                    maxIndex=i;
                }

            }return max;
        }}

    /**
     * 找到数组中最小的值的索引
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static int findMinIndex(int[] arr) {
        if (arr.length<2) {
            throw new IllegalStateException("数组没有元素,或只有1个元素,无法排序!");
        }else {
            int size = arr.length;
            //假设第一个数就是最小数字,或者说以其为基准
            int minIndex = 0;
            int min = arr[0];
            //第一次遍历,从index为1 开始
            //消耗空间复杂度O(1),存放index
            for (int i = 1; i <size ; i++) {
                if (arr[i] < min) {
                    //重新选择小的为基准
                    min = arr[i];
                    minIndex=i;
                }

            }return minIndex;
        }

    }

    /**
     * 找到数组中最小的值
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static int findMin(int[] arr) {
        if (arr.length<2) {
            throw new IllegalStateException("数组没有元素,或只有1个元素,无法排序!");
        }else {
            int size = arr.length;
            //假设第一个数就是最小数字,或者说以其为基准
            int minIndex = 0;
            int min = arr[0];
            //第一次遍历,从index为1 开始
            //消耗空间复杂度O(1),存放index
            for (int i = 1; i <size ; i++) {
                if (arr[i] < min) {
                    //重新选择小的为基准
                    min = arr[i];
                    minIndex=i;
                }

            }return min;
        }}







}
