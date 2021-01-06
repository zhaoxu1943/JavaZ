package com.practice.DataStructureAndAlgorithm.ProcessArray;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhaoxu
 * @className FindDuplicateNum
 * @projectName JavaConcentration
 * @description 数组中有两个整数是重复的,要求找出这两个重复的整数
 * @date 4/16/2020 7:22 PM
 */
public class FindDuplicateNum {

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,5,4,9,7,2};
        //双循环
        System.out.println(findDupNumOne(arr));
        //hashMap
        System.out.println(findDupNumHashMap(arr));

    }


    /**
     * @author zhaoxu
     * @description  使用双循环解决,时间复杂度为O(n^2),空间复杂度为O(1),仅仅用了一个基本数据类型  int result作为临时空间;
     * @params int[] arr
     */
    public static int findDupNumOne(int[] arr) {


        int result = 0;
        //双循环,拿出数组中的一个元素,再去遍历数组中的其他元素
        for (int i :arr) {
            for (int j = 0; j <arr.length ; j++) {
                //计数器
                int num = 0;
                //如果说i==arr[j],即匹配到元素,就计数器加一
                if (i==arr[j]){num++;}
                    //一直匹配直到找到计数器为2的数字,此时跳出第一层循环
                    if (num==2){break;}

                //这里也只能写在内循环中,否则外层顺序执行后,在第一个数字就会break
                //跳出到了外层循环中
                //将当前结果赋值给返回值result
                result =i;
                //跳出外层循环
                break;
            }

        }
        return result;
    }


    /**
     * @author zhaoxu
     * @description 使用HashMap,这里时间复杂度为循环数组n+遍历n,时间复杂度为T(n)=O(n),但是虽然说比双循环的N^2减少了
     * 时间复杂度,但是使用了HashMap作为临时储存空间,增加了空间复杂度
     * 1. 常量空间:当使用的存储空间大小固定,和输入的规模无关,空间复杂度为O(1)
     * 2. 线性空间:当算法分配的是一个线性的集合,集合大小和输入规模n成正比,如本例,将数组array放进几乎同等空间的HashMap中,空间复杂度为O(n)
     * 3. 二维空间:当算法分配的空间是一个二维数组集合,如
     *
     *             void function(int n) {
     *                 int[][] matrix = new int[n][n];
     *             }
     * 此时空间复杂度为O(N^2)
     * 4.递归空间
     * 在Java运行时内存区域的JVM虚拟机栈中,方法的执行对应栈帧的入栈,而方法执行完毕对应栈帧的出栈
     * 递归时,按照递归,各递归方法依次入栈,待达到递归结束时,再依次出栈
     * 由此可见,递归需要的内存空间与递归深度成正比,若递归深度为n,那么空间复杂度为O(N)
     *
     * 时间复杂度为O(n),空间复杂度为O(n),牺牲空间换取时间
     * @params
     */
    public static int findDupNumHashMap(int[] arr) {
        // hashMap计算容量大小 0.75+1
        Map<Integer,Integer>  hashMap = new HashMap<>(12);
        int result = 0;
        //这里要重复计数,计数器不能写在循环体
        int num =1;
        for (int i:arr) {
            if (hashMap.containsKey(i)){
                // ++num和num++,一个是先++,再返回,一个是先返回再++,这里应该用++num
                hashMap.put(i,++num);
            }else {
                hashMap.put(i,num);
            }

        }
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry) iterator.next();
            if(entry.getValue()==2){
                result=entry.getKey();
                break;
            }
        }
        return result;
    }
}
