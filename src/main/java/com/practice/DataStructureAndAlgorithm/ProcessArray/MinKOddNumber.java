package com.practice.DataStructureAndAlgorithm.ProcessArray;

import org.omg.IOP.CodecOperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 第k小奇数
 * @author zhaoxu
 * @className MinKOddNumber
 * @projectName JavaConcentration

 * @date 3/25/2020 3:16 PM
 */
public class MinKOddNumber {

    public static void main(String[] args) {
        //条件arr[i]>0;
        int[] arr  = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(findKth(arr,3));

    }


    public static   int findKth(int arr[],int k) {
        if (arr.length==0){
            return 0;
        }else {
            //遍历取出所有奇数,放到可变的ArrayList中
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i : arr) {
                if ((i & 1) != 0) {
                    arrayList.add(i);
                }
            }

            Collections.sort(arrayList);

            System.out.println(arrayList);

            //冒泡排序将ArrList排序
            if (k>arrayList.size()){
                return 0;
            }else {
                for (int i = 0; i < arrayList.size(); i++) {
                    for (int j = i + 1; j < arrayList.size(); j++) {
                        if (arrayList.get(i) > arrayList.get(j)) {
                            int num = arrayList.get(i);
                            arrayList.set(i, arrayList.get(j));
                            arrayList.set(j, num);
                        }
                    }
                }
                return arrayList.get(k-1);
            }
        }

    }

}
