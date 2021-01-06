package com.readbooks.TJAlgorithm.C4;

import java.util.Arrays;

/**
 * 计算列表包含的元素数
 * 把握一个点,即列表问题的基线条件通常是数组为空或只包含一个元素
 * @author zhaoxu
 * @className CountElementDC
 * @projectName JavaConcentration
 * @date 2020/12/16 12:14
 */
public class CountElementDC {


    public static void main(String[] args) {
        int[] intArr  = new int[]{1,2,32,32,32,3};
        System.out.println(getCount(intArr));
    }


    private static int getCount(int[] arr) {
        //先点名基线条件
        if (arr.length==0){
           return 0;
        }else{
            return 1+getCount(Arrays.copyOfRange(arr,1,arr.length));
        }
    }





}
