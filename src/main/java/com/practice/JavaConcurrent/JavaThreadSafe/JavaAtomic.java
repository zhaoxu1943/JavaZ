package com.practice.JavaConcurrent.JavaThreadSafe;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName JavaTimingOperation
 * @Description 非原子性操作导致的问题
 * @Author zhaoxu
 * @Date 2019/11/21 15:42
 * @Version 1.0
 **/
public class JavaAtomic {

        synchronized void removeObject() {
        //这种依赖时序的非原子性操作,先检查后操作,执行中可能被打断
            //还有数据相互绑定的问题,如成组的ip和端口号是相互绑定的,如果不锁成原子性操作,那么会出现线程安全的问题
            //还有就是使用了非线程安全的类,非要用的话,如ArrayList,那也得加一个Synchronized,如果不加锁的原因导致了线程安全,不是人家ArrayList的锅
        HashMap hashMap = new HashMap();
            if(hashMap.containsKey("key")){
                hashMap.remove("key");
            }
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger =new AtomicInteger(1);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger);
        AtomicBoolean atomicBoolean =new AtomicBoolean(false);
        AtomicLong atomicLong = new AtomicLong(123L);
       // AtomicStampedReference atomicStampedReference = new String();

    }
}
