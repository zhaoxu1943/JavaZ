package com.practice.DataStructureAndAlgorithm.tencent.leetcode;

import com.google.common.collect.Maps;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 腾讯第一题 两数之和
 * @author zhaoxu
 * @className SumOfTwoNums_1
 * @projectName JavaConcentration
 * @date 2020/5/20 7:49
 */
public class SumOfTwoNums_1 {


    public static void main(String[] args) {
        //测试用例,存在相同数字
        int[] nums = new int[]{3,3};
        int target = 6;

        //测试用例,普通的(没有相同数字)
//        int[] nums = new int[]{2,7,12,9};
//        int target = 9;

        int[] ints = twoSumMyOneHash_1(nums,target);
        for (int i:ints) {
            System.out.println(i);
        }

//        int[] ints = twoSumMyTwoHash_1(nums,target);
//
//        for (int i:ints) {
//            System.out.println(i);
//        }



    }


    /**
     * 我的题解,一遍hash表,根据官方的思路和我们2遍hash表的实践,
     * 发现两次遍历的都是一样的,所以1遍hash加每次检查即可,
     * put操作要在后,因为有相同元素时,put在前,如fori循环到0,put进map(3,0),如fori循环到1,put进map(3,1),这样是永远找不到的
     * 用containsValue的话,原生API无法从value获取key
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int[]  twoSumMyOneHash_1 (int[] nums ,int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int numWanna = target - nums[i];
            if (map.containsKey(numWanna)&&i!=map.get(numWanna)){
                return new int[] {i,map.get(numWanna)};
            }
            map.put(nums[i],i);
        }throw new IllegalArgumentException("没这回事!");
    }



    /**
     * 官方题解 两遍hash表_1
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */

        public static int[] twoSumOfficialTwoHash_1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }

    /**
     * 我的题解 两遍hash表_2
     * 
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int[] twoSumMyTwoHash_2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        //第一次遍历
        for (int i = 0; i < nums.length; i++) {
            //自动装箱,值为key,下标为value,由于key不重复,第二次的会把第一次的覆盖掉
            map.put(nums[i],i);
        }
        //第二次遍历,遍历数组,由于map第二次的会把第一次的覆盖掉
        //所以不能使用foreach循环,foreach循环没有下标,没有结果
        for (int i = 0; i < nums.length; i++) {
            //希望找到的num
            int numWanna = target - nums[i];
            //int和Integer(无论new否)使用==或者!=,会把Integer自动拆箱为int再去比。
            if (map.containsKey(numWanna)&&i!=map.get(numWanna)) {
                return new int[] {i,map.get(numWanna)};
            }
        }
        throw new IllegalArgumentException("没这回事!");
    }

    /**
     * 我的题解 两遍hash表_1
     * 想到hash表的原理,即通过hash函数实现快速查找
     * 由于两数之 x+y=sum 的判定,改为简单的 已知x   寻找 sum-x 即可,利用hashmap的containsKey函数可以快速完成
     * 保持数组中的每个元素与其索引相互对应,还能快速查找,的最好方法是什么？哈希表。
     *
     * 我们算法1的复杂度主要是数组按下标查找带来的双循环问题,
     * 这里我们用空间换取时间,空间复杂度O(N)
     *
     * 经过两次遍历,第一次遍历数组,放入hashmap,
     * 第二次遍历数组(这里我foreach遍历的是hashmap,其实遍历数组是一样的,还是那几个元素)
     * 遍历出来的元素x,去hashmap中寻找target-x即可,如果有就返回下标
     * 此时时间复杂度为O(N)
     *
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int[] twoSumMyTwoHash_1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        //第一次遍历
        for (int i = 0; i < nums.length; i++) {
            //自动装箱,值为key,下标为value,由于key不重复,第二次的会把第一次的覆盖掉
            map.put(nums[i],i);
        }
        //第二次遍历,遍历数组,由于map第二次的会把第一次的覆盖掉
        //所以不能使用foreach循环,foreach循环没有下标,没有结果
        for (int i = 0; i < nums.length; i++) {
            //希望找到的num
            int numWanna = target - nums[i];
            //int和Integer(无论new否)使用==或者!=,会把Integer自动拆箱为int再去比。
            if (map.containsKey(numWanna)&&i!=map.get(numWanna)) {
                return new int[] {i,map.get(numWanna)};
            }
        }
        throw new IllegalArgumentException("没这回事!");
    }


    /**
     * 官方题解1 暴力_1
     * 使用直接return,解决了需要break for循环的问题,并做了异常处理,IllegalArgumentException 非法参数异常
     * 暴力法很简单，遍历每个元素 xx，并查找是否存在一个值与 target - x 相等的目标元素。
     * 时间复杂度为 O(n^2)
     * 空间复杂度O(1),仅使用常量空间
     * 由于两数之 x+y=sum 的判定,改为简单的 已知x   寻找 sum-x 两数对比的判定
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int[] twoSumOfficialForce_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 我的题解 暴力_2
     * 2020.05.20写法
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */

        public static int[] twoSumMyForce_2(int[] nums, int target) {
            int[] result = new int[2];
            int length = nums.length;
            int i;
            int j;
            for(i=0;i<length;i++) {
                for(j=i+1;j<length;j++) {
                    int sum = nums[i]+nums[j];
                    if(sum==target) {
                        result[0]=i;
                        result[1]=j;
                        //跳出内层循环
                        break;
                    }
                    //跳出外层循环
                    if ( result[0]==i&&result[1]==j){
                        break;
                    }
                }
                Instant end = Instant.now();
            } return result;
        }


        /**
         * 我的题解 暴力_1
         * 2020.03.20 写法
         * @author zhaoxu
         * @param
         * @return
         * @throws
         */
        public static int[] twoSumMyForce_1(int[] nums, int target) {
            int[] index = new int[2];
            for (int i = 0; i <nums.length ; i++) {
                for (int j = i+1; j <nums.length ; j++) {
                    if (nums[i]+nums[j]==target&&i!=j){
                        index[0]=i;
                        index[1]=j;
                    }
                }
            }
            return index;
        }

}
