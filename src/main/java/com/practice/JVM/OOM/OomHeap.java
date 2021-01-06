package com.practice.JVM.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxu
 * @version 1.0
 * @className OomHeap

 * @date 2019/12/10 9:27
 *
 * VM args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
 **/
public class OomHeap {

    static class Oom {
        void print(int i){
            System.out.println(i+"OOM");
        }
    }

    public static void main(String[] args) {
        //这样写的话,没有保持引用,new多少回收多少
//        for (int i = 0; i < 100000; i++) {
//             new Oom().print(i);
//        }

        List<Oom> list = new ArrayList<>();
        while (true) {
            list.add(new Oom());
        }


    }




}
