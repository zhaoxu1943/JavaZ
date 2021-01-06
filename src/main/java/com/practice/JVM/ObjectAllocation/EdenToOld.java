package com.practice.JVM.ObjectAllocation;

/**
 * @author zhaoxu
 * @version 1.0
 * @className EdenToOld
 * @description eden中空间不足,借老年代来担保
 * @date 2019/12/11 15:59
 * vm args -XX:+UseSerialGC -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -XX:+PrintGCTimeStamps -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 **/
public class EdenToOld {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws InterruptedException {
       //维护1个Byte数组,里面有1024*1024个Byte元素,自然是1MB
        Byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new Byte[2 * _1MB];
//        allocation2 = new Byte[2 * _1MB];
//        allocation3 = new Byte[2 * _1MB];
//        allocation4 = new Byte[4 * _1MB];
        Thread.sleep(9000000);
    }
}
