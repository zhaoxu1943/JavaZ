package com.practice.JavaConcurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @ClassName MultiThread
 * @Description 多线程的理解,只是一个main,已经有很多线程
 * @Author zhaoxu
 * @Date 2019/11/18 16:31
 * @Version 1.0
 **/
public class MultiThread {

    //只是一个main方法 就有很多线程

    public static void main(String[] args) {
        //java线程管理MXbean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true,true);

        for (ThreadInfo threadInfo:threadInfos) {
            System.out.println(threadInfo);
        }

    }
}
