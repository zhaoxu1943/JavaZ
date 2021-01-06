package com.practice.JavaContainer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author zhaoxu
 * @version 1.0
 * @className JavaList
 * @description
 * @date 2019/12/15 0:07
 **/
public class JavaList {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        //System.out.println(list.get(-1));
        Iterator iterator =  list.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
