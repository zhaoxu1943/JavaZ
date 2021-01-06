//package com.practice.JVM.OOM;
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
///**
// * @author zhaoxu
// * @version 1.0
// * @className DirectMemoryOOM
//
// * @date 2019/12/10 11:33
// *
// * VM args -Xmx20m -XX:MaxDirectMemorySize=10M
// **/
//public class DirectMemoryOOM {
//
//    private static final int _1MB = 1024*1024;
//
//    public static void main(String[] args) {
//        Unsafe unsafe = null;
//        try {
//            Field field = Unsafe.class.getDeclaredFields()[0];
//            field.setAccessible(true);
//            unsafe = (Unsafe)field.get(null);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        while (true){
//            unsafe.allocateMemory(_1MB);
//        }
//    }
//
//}
