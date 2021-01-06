package com.concentration.util;

/**
 * @author zhaoxu
 * @className ZxUtil
 * @projectName JavaConcentration
 * @description 赵旭的工具类
 * @version 0.1 首次创建,添加getCurrentWeek(),得到当前第几周
 * @date 4/1/2020 8:26 AM
 */
public class ZxUtil {

    //结构为 私有构造+静态方法
    private ZxUtil() {}


    /**
     * 打印原生数组
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void printArray(int[] arr) {
        for (int i: arr){
            System.out.println(i);
        }
    }


}

