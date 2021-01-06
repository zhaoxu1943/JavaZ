package com.practice.DataStructureAndAlgorithm.leetcode;

import java.util.*;

/**
 * leetcode - 239 滑动窗口最大值
 * @author zhaoxu
 * @param
 * @return
 * @throws
 */
public class MaxSlidingWindow_239 {


    public static void main(String[] args) {
        //实现一个队列
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for (String q : queue) {
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll=" + queue.poll()); //返回第一个元素，并在队列中删除
        for (String q : queue) {
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element=" + queue.element()); //返回第一个元素
        for (String q : queue) {
            System.out.println(q);
        }

        //poll，remove 区别：
        //
        //remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
        //
        //peek，element区别：
        //
        //element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。
        System.out.println("===");
        System.out.println("peek=" + queue.peek()); //返回第一个元素
        for (String q : queue) {
            System.out.println(q);
        }


        //滑动窗口问题
            int[] nums = {1,3,-1,-3,5,3,6,7,3};
            int k  = 2;
            int[] result = maxK(nums,k);
            System.out.println(Arrays.toString(result));


    }

    public static int[] maxK(int[] nums,int k){
        //nums有n(n>=k)个元素 那么一共需要取n-k+1次
        int n = nums.length-k+1;
        //new ArrayList 不能像数组啦 要 new 不然只是一个地址
        ArrayList<Integer> temp = new ArrayList<>();
        //初始化一个n的数组 因为一共需要取n次
        int[] result= new int[n];
        //时间复杂度为O(mn)
        //先遍历一共要取多少次窗口
        for (int i=0;i<n;i++){
            //再针对单个窗口,取对应的k个数,取最大
            for (int j = i;j<i+k;j++){
                temp.add(nums[j]);
            }
            temp.sort(Integer::compareTo);
            result[i] = temp.get(temp.size()-1);
        }

    return result;
    }
}
