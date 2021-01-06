package com.practice.DataStructureAndAlgorithm.processHashTable.JavaHashMap;

import java.util.HashMap;

/**
 * hashmap 的无限循环
 *
 * @ClassName HashMapInfiniteLoop

 * @Author zhaoxu
 * @Date 2019/11/13 16:21
 * @Version 1.0
 **/
public class HashMapInfiniteLoop {

    private static HashMap<Integer,String> map = new HashMap<Integer,String>(2,0.75f);
    public static void main(String[] args) {
        map.put(5,"C");

        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            };
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                        System.out.println(map);
            };
        }.start();
    }
}