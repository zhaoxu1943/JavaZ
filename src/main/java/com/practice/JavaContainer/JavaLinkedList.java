package com.practice.JavaContainer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaoxu
 * @className JavaLinkedList
 * @projectName JavaConcentration

 * @date 2/19/2020 12:10 PM
 */
public class JavaLinkedList {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("z");
        list.add("h");
        list.add("a");
        list.add("0");
        list.add("x");
        Iterator iterator= list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }
}
