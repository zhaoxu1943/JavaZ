package com.readbooks.TJAlgorithm.C4;

/**
 * @author zhaoxu
 * @className DCUtil
 * @projectName JavaConcentration
 * @date 2020/12/16 12:17
 */
public class DCUtil {



    /**
     * 去掉数组第一个元素后的数组
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int[] deleteIndex0ElementArr(int[] arr) {
        if (arr.length==0){
            return new int[0];
        }else{
            int[] resultArr = new int[arr.length-1];
            System.arraycopy(arr,1,resultArr,0,arr.length-1);
            return  resultArr;
        }
    }

}
