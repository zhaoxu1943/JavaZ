package com.practice.DataStructureAndAlgorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

//leetcode 739 每日温度
//题目描述
//根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
//
//例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//————————————————
//版权声明：本文为CSDN博主「请点击头像」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/u012836896/article/details/86657168
public class Temperature_739 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间

        //声明一个int[]数组,并初始化为给定值
        int[] temperatures = {23, 24, 25, 21, 19, 22, 26, 23};
        //仅声明
        int[] a;
        //声明并初始化为0
        int[] a1 = new int[5];

        int[] result = chuli1(temperatures);
        int[] resultstack = chulistack(temperatures);
        long endTime = System.currentTimeMillis(); //获取结束时间

        //输出数组不能直接输出,否则会输出数组第一个元素的地址
        //使用Arrays类中的toString方法
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(resultstack));
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    //使用O(n^2)双循环复杂度
    public static int[] chuli1(int[] temp) {
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < temp.length - 1; j++) {
                if (temp[i] < temp[j]) {
                    result[i] = j - i;
                    //这里算出来之后,要直接break,因为只要比一次就够了
                    break;
                }
            }
        }
        return result;
    }

    //使用stack O(n)解决 stack存的是数组的下标,因为输出实际上跟温度本身没关系
    public static int[] chulistack(int[] temp) {
        int[] result = new int[temp.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
           while (!stack.empty() && temp[stack.peek()]<temp[i]){
                int t = stack.pop();
                result[t] = i-t;
           }
          stack.push(i);
        }
        return result;
    }
}
