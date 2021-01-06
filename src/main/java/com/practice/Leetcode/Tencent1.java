package com.practice.Leetcode;

import java.util.HashMap;

/**
 * @author zhaoxu
 * @className Tencent1
 * @projectName JavaConcentration

 * @date 3/11/2020 10:34 PM
 */
class Tencent1 {

    public static void main(String[] args) {
        int[] nums ={2,7,11,15};
        int target = 21;
        Tencent1 tencent1= new Tencent1();
        System.out.println(tencent1.twoSum(nums,target));
    }


//    public int[] twoSum(int[] nums, int target) {
//        int[] index = new int[2];
//        for (int i = 0; i <nums.length ; i++) {
//            for (int j = i+1; j <nums.length ; j++) {
//                if (nums[i]+nums[j]==target&&i!=j){
//                    index[0]=i;
//                    index[1]=j;
//                }
//            }
//        }
//        return index;
//    }



        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target-nums[i])&&map.get(target-nums[i])!=i) {
                    return new int[]{i,map.get(target-nums[i])};
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }


}