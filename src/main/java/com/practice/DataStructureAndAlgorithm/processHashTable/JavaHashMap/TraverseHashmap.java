package com.practice.DataStructureAndAlgorithm.processHashTable.JavaHashMap;

import java.util.*;

/**
 * 遍历hashmap
 *
 *
 * @ClassName

 * @Author zhaoxu
 * @Date 2019/11/13 17:00
 * @Version 1.0
 **/
public class TraverseHashmap {

    public static void main(String[] args) {


        Map hashmap = new HashMap(1,1);

        hashmap.put("nihao1",123);
        hashmap.put("wohao2",456);
        hashmap.put("wohao3",456);
        hashmap.put("wohao5",456);
        hashmap.put("wohao4",456);
        hashmap.put("wohao6",456);
        hashmap.put("wohao7",456);
        hashmap.put("wohao8",456);


    int i = 14;
        System.out.println(i);

        Iterator it = hashmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry);
        }

    }
}
