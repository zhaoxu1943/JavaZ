package com.practice.JavaContainer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author zhaoxu
 * @className JavaHashMapItertor
 * @projectName JavaConcentration

 * @date 3/24/2020 2:41 PM
 */
public class JavaHashMapItertor {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("name","zhaoxu");
        hashMap.put("age","你好");
        hashMap.put("error","大萨达");

        //第一种方式 通过hashmap的keySet(),获取key的集合,再通过foreach 遍历出value
        Set<String> strings = hashMap.keySet();
        for (String s:strings) {
            System.out.println("key "+s+"value"+hashMap.get(s));
        }


        //hashMap.entrySet()加遍历器 遍历hashmap
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //第三种 推荐方式
        //第三种:通过Map.entrySet遍历key和value

        for (Map.Entry<String,String> entry:hashMap.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }


    }
}
