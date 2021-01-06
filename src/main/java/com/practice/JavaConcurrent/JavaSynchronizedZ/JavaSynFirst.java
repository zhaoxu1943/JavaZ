package com.practice.JavaConcurrent.JavaSynchronizedZ;

import java.util.List;
import java.util.Vector;

/**
 * @author zhaoxu
 * @className JavaSynFirst
 * @projectName JavaConcentration

 * @date 3/4/2020 7:37 PM
 * // use biased lock     delay =0
 * jvm  -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 */
public class JavaSynFirst {

    private static List<Integer> list = new Vector<>();
    public  static void main(String[] args) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000000; i++) {
                list.add(i + 2);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }

    }

