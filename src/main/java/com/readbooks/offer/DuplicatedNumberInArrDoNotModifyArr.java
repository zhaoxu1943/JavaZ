package com.readbooks.offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 面试题3:数组中的重复数字
 *
 * 在一个长度为n的数组里,所有数字都在 0 到 n-1的范围内
 * 数组中某些数字是重复的
 * 但不知道有几个重复了
 * 也不知道重复了几次
 *
 * 不能修改数组!
 *
 * 请找出数组中任意的一个重复的数字
 * @author zhaoxu
 * @className DuplicatedNumberInArr
 * @projectName JavaConcentration
 * @date 2020/12/15 12:52
 */
public class DuplicatedNumberInArrDoNotModifyArr {

  public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 4, 2, 3};
        System.out.println(findRepeatNumber3(arr));
  }

    /**
     * 我最初解法(朴素的双循环法)'
     * 不修改数组
     * 力扣有时会超时,此时间复杂度为O(n^2)
     * 2020.12.16
     *
     * 问题:
     * 1.双循环如何跳出? 直接return中止程序
     * 2.异常没有处理  循环后抛出
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        throw new IllegalArgumentException("输入数组中没有两个相同元素!");
    }




    /**
     * 书上解法2,hashmap法
     *
     * 可以不修改数组
     * 利用hashmap的contains用O(1)的时间判断
     *
     * 时间复杂度 O(n)，对于数据规模 10 万级别的话，运行速度是可以接受的。但是这里的空间复杂度则变为 O(n)，因为哈希表需要申请额外的 n 个空间，这里用到的是典型的空间换时间的思想
     * 空间复杂度为O(n)
     * 作者：tangweiqun
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/duo-chong-jie-fa-xun-xu-jian-jin-yi-zhi-dao-zui-yo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int findRepeatNumber3(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                return nums[i];
            }else {
                hashMap.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("输入数组中没有两个相同元素!");
    }


}
