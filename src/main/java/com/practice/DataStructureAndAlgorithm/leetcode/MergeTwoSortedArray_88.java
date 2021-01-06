package com.practice.DataStructureAndAlgorithm.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 合并两个有序数组
 * @author zhaoxu
 * @className MergeTwoSortedArray
 * @projectName JavaConcentration
 * @date 2020/5/28 17:37
 */
public class MergeTwoSortedArray_88 {

    public static void main(String[] args) {
        //nums1的初始化容量,num1.size>=m+n

        //nums1中的实际元素数量为m
        int m = 3;
        int[] nums1 = new int[]{1,2,3,0,0,0};
        //nums2中的实际元素数量为n
        int n = 3;
        int[] nums2 = new int[]{2,5,6};
        //merge(nums1,m,nums2,n);
        //mergeTwoPointAscZ(nums1,m,nums2,n);
        //mergeTwoPointDescZ(nums1,m,nums2,n);
        mergeTwoPointDescOfficial(nums1,m,nums2,n);
        for (int i :nums1) {
            System.out.println(i);
        }

    }
    /**
     * 使用java自带的System函数
     * 合并数组
     * 即把nums2 从nums2的index为0开始,合并到nums1的从index m开始,合并长度为length
     * 复杂度为Arrays.sort函数本身的时间复杂度O((m+n)log(m+n))//TODO 了解java本身的快排算法
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //System函数合并数组.5个参数
        //srcArray 原始数组
        //srcPos 原始数组copy起始位置
        //DestSrc 目的数组
        //destPos 目的数组copy放置的位置
        //length 拷贝的长度
        System.arraycopy(nums2,0,nums1,m,n);
        //然后用Arrays排序
        Arrays.sort(nums1);
    }



    /**
     * 双指针/从前往后
     * 对于有序数组可以通过双指针法达到O(n+m)的时间复杂度
     * 指针即移动的数组下标
     * 从前往后,num1元素copy nums1_copy为p1指针,而nums2为p2指针
     * num1_copy为1 2 3 而 nums2 为2 5 6
     * nums_copy[p1]和nums2[p2]进行比较后,p1 小
     * 此时p1指针前进,p2指针不动
     * nums1 p指针前进 这样就利用了其有序的特性,空间复杂度为O(m)
     * 时间复杂度为O(m+n)
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void mergeTwoPointAscOfficial(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1 exists element          引入额外的空间复杂度O(m)
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        //nums1 是输出数组,声明两个 get point
        int p1 = 0;
        int p2 = 0;

        //一个 Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }












    /**
     * 自己手写双指针法/从前到后
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void mergeTwoPointAscZ(int[] nums1, int m, int[] nums2, int n) {
        //nums1 为输出数组,需要拷贝其存在的值,O(m)空间复杂度
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);

        //定义指针
        //输出数组指针
        int p = 0;

        //数据源数组双指针
        int p1 = 0;
        int p2 = 0;
        //判定指针在数组下标范围内,防止数组下标越界
        while (p1<m&&p2<n) {
            nums1[p++] = nums1_copy[p1]<nums2[p2] ?nums1_copy[p1++]:nums2[p2++];
        }

        //此时p1添加完了,而p2还剩两个元素,分别判定p1指针和p2指针 ,剩下的一定是最大的,且有序
        //
        if (p1 < m){
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2<n) {
            System.arraycopy(nums2,p2,nums1,p1+p2,m + n - p1 - p2);
        }
    }



    /**
     * 自己手写双指针法/从后往前
     * 不需要额外的空间复杂度
     * 思路:从前往后时,需要对输出数组nums1实际值,进行拷贝
     * 接着nums1_copy和nums2 使用双指针从小到大置入输出数组nums1
     * 从后往前即直接使用nums1的空白元素,节省O(m)的空间复杂度
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void mergeTwoPointDescZ(int[] nums1, int m, int[] nums2, int n) {
        //双指针,从后往前
        //第一个指针指在nums1最后一个元素
        int p1 = m-1;
        //第二个指针指在nums2最后一个元素
        int p2 = n-1;

        //输出数组指针(还是nums1),应该是m+n-1,如果是
        //nums1.length-1的话,可能数组本来的元素更多,中间就空出来了
        int p = m+n-1;

        //指针移动
        while (p1>=0 && p2>=0){
            nums1[p--] = nums1[p1]<nums2[p2] ? nums2[p2--]:nums1[p1--];
        }


    }



    /**
     * 双
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void mergeTwoPointDescOfficial(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }




    public void mergeTwoPointDescGoodComment(int[] nums1, int m, int[] nums2, int n) {
        // 三指针 指针一p1、nums1有效元素尾部；指针二p2、nums2尾部；指针三p3、最终数组尾部
        // 1.当，p1>=0时，nums[p1],nums[p2]对比
        // 1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
        // 1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
        // 2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3--
        // 循环结束条件：p2<0

        int p1=m-1,p2=n-1,p3=m+n-1;
        while(p2 >= 0){
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }
}