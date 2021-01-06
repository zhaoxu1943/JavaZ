package com.practice.JavaContainer;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName JavaCollections
 * @Author zhaoxu
 * @Date 2019/11/20 13:48
 * @Version 1.0
 **/
public class JavaCollections {

     /**
     * @Author zhaoxu
     * @Date 12:19 2019/11/22
     * {@link java.util.Collection}
      * {@link java.util.Arrays}
      * @Param
     * @return
     **/
     public static void main(String[] args) {
          //最简单的集合,数组,数组的长度是不可变的
          Integer[] ints = new Integer[5];
          int[] ints1 = {1,2,3,4,5};
          //数组的长度固定
          //集合的长度可变
          //3:元素的数据类型
          //
          //数组可以存储基本数据类型,也可以存储引用类型
          //
          //集合只能存储引用类型(你存储的是简单的int，它会自动装箱成Integer)

          List<Integer> list = new ArrayList<>();
          //arrays to ArrayList
          list = Arrays.asList(ints);
          //ArrayList to arrays
          list.toArray();



     }

}
