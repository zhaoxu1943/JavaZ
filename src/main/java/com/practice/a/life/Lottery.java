package com.practice.a.life;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 对于数组的基础操作,数组随机访问
 * @author zhaoxu
 * @className BasicProcessArray
 * @projectName JavaConcentration
 * @date 2020/6/24 8:32
 */
public class Lottery {


    public static void main(String[] args) throws InterruptedException {
        String[] nameList =  new String[] {"张辉","林恒","申越兴","刘超","林林",
                "李艳","艾冲","张红恩","刘航","王进程",
                "武文杰","朱珍亮","赵旭","韩特","张润",
                "赵原跃","胡高伟","熊晶","邓晗"};
        randomAccessArray(nameList);
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
    public static void  randomAccessArray(String[] arr) throws InterruptedException {
        int size = arr.length;
        System.out.println("本次抽奖参与人数"+size+"人"+Arrays.toString(arr));
        System.out.println("开始抽奖,请等待...");
        Thread.sleep(5000);
        Random random = new Random();
        //int类型的数字流,含首不含尾
        IntStream intStream = random.ints(0, arr.length)
                                    //不重复
                                    .distinct()
                                    //选取两位
                                    .limit(2);
        System.out.println("抽奖结果:");
        //输出
        intStream.forEach(i-> System.out.println(arr[i]));
    }

}
