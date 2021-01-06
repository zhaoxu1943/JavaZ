package com.practice.JVM.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxu
 * @version 1.0
 * @className RuntimeConstantPool

 * @date 2019/12/10 10:20
 * VM args -Xms10m -Xmx10m
 *
 **/
public class RuntimeConstantPool {

    private static int i;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while(true) {
          list.add(String.valueOf(i++).intern());
        }
    }
}
