package com.practice.JVM.GC;

/**
 * @author zhaoxu
 * @version 1.0
 * @className ReferenceCountingGC
 * @description 探究引用计数算法的缺点
 * @date 2019/12/10 12:24
 **/
public class ReferenceCountingGC {

    public Object instance =null;
    private static final int _1MB = 1024*1024;

    //占点内存,看清是否GC
    private byte[] bigSize = new byte[2*_1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        //对象a和b都有一个instance字段互相引用对方,但是这两个对象明显不可能再被访问
        try {
            objA.instance = objB;
            objB.instance = objA;
            objA = null;
            objB = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //执行垃圾回收
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
