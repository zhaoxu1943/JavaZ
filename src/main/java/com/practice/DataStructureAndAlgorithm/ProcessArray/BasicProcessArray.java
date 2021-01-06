package com.practice.DataStructureAndAlgorithm.ProcessArray;

import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 对于数组的基础操作
 * @author zhaoxu
 * @className BasicProcessArray
 * @projectName JavaConcentration
 * @date 2020/6/24 8:32
 */
public class BasicProcessArray {


    public static void main(String[] args) {
        int[] arr =  new int[] {1,32,23,123,54,76,898,2};
        //数组支持随机访问,即下标访问
        //randomAccessArray(arr);
        //尾部不超范围插入
        //tailInsertArray();

    }


    /**
     * java.util.Random生成自定义随机数,范围为数组下标,从无限流中随机输出10次
     * 也就是随机访问输出数组元素,10次
     *
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void  randomAccessArray(int[] arr) {
        Random random = new Random();
        //无穷尽的int类型的数字流
        IntStream intStream = random.ints(0, arr.length-1);
        //限制输出10位,并foreach打印
        //方式一,遍历
//        Iterator iterator= intStream.limit(10).iterator();
//        while (iterator.hasNext()) {
//            int  i= (int) iterator.next();
//            System.out.println(arr[i]);
//        }
        //方式二,Stream
        intStream.limit(1).forEach(i-> System.out.println(arr[i]));
    }


    /**
     *
     * 尾部插入
     * insert to array
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static void tailInsertArray() {
        Integer[] arr = new Integer[6];
        for (int i = 0; i < 4; i++) {
        //为前4个元素赋值,将 空余两个被初始化为null的对象
        arr[i] = 5;
    }
        //打印数组,5 5 5 5 null null
        ArrayBasicKnowledge.printArray(arr);

        //尾部插入,是最简单的情况,直接把元素放在数组尾部,空闲位置即可,等于更新元素的操作
        arr[5] = 9;
        ArrayBasicKnowledge.printArray(arr);
    }






}
