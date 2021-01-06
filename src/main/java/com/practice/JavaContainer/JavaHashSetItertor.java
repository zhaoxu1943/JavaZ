package com.practice.JavaContainer;

import java.util.*;

/**
 * @author zhaoxu
 * @className JavaHashMapItertor
 * @projectName JavaConcentration

 * @date 3/24/2020 2:41 PM
 */
public class JavaHashSetItertor {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("dasdsa");
        hashSet.add("dnasi");
        hashSet.add("dsa");


        //第一种方式 foreach ,元素遍历
        for (String s:hashSet) {
            System.out.println(s);
        }


        //hashMap.entrySet()加遍历器 遍历hashmap
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
