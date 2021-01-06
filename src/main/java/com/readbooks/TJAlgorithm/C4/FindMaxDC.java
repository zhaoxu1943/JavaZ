package com.readbooks.TJAlgorithm.C4;

import java.util.Arrays;

/**
 * @author zhaoxu
 * @className FindMaxDC
 * @projectName JavaConcentration
 * @date 2020/12/16 12:22
 */
public class FindMaxDC {


    public static void main(String[] args) {
        int[] intArr  = new int[]{1,2,3322,321,323232,3};
        System.out.println(getMax(intArr));
    }


    private static int getMax(int[] arr) {
        if (arr.length==0){
            throw new IllegalArgumentException("数组为空时无最大值");
        }else if (arr.length==1){
            return arr[0];
        }else{
            return Math.max(arr[0],getMax(Arrays.copyOfRange(arr,1,arr.length)));
        }
    }



}
