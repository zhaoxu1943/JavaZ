package com.practice.JavaContainer;

import com.google.common.collect.Maps;
import org.apache.ibatis.mapping.MappedStatement;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhaoxu
 * @className JavaTreeMap
 * @projectName JavaConcentration
 * @date 2020/7/27 11:28
 */
public class JavaTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = Maps.newTreeMap();
        treeMap.put(2,"test2");
        treeMap.put(1,"test1");
        treeMap.put(8,"test8");

        treeMap.forEach((integer, s) -> System.out.println(integer+s));

    }
}
