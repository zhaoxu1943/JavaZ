package com.practice.JavaContainer;

import com.practice.JavaBasicFeatures.JavaExtends.Cat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName JavaMaps
 * @Author zhaoxu
 * @Date 2019/10/15 14:50
 * @Version 1.0
 **/
public class JavaMaps {
     public static void main(String[] args) {
          Cat cat = new Cat("cat",1);
          Cat dog = new Cat("123",2);
          Map<String,Cat> hashMap = new HashMap(8);
          hashMap.put("cat",cat);
          hashMap.put("dog",dog);
          System.out.println(hashMap.size());
          boolean b = hashMap.containsValue(cat);
          System.out.println(b);
          hashMap.remove("cat");
          //remove有两种实现
          //remove(Object key)
          //remove(Object key, Object value)
          //所以说remove value中的对象是不可以的,不生效
          System.out.println(hashMap.size());
          Map linkedHashMap = new LinkedHashMap();
          Map treeMap = new TreeMap();
          Map concurrentHashMap = new ConcurrentHashMap();
     }




}
