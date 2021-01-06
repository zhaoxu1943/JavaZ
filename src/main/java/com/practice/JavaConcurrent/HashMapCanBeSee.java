package com.practice.JavaConcurrent;

import java.util.HashMap;

/**
 * @author zhaoxu
 * @className HashMapCanBeSee
 * @projectName JavaConcentration

 * @date 3/14/2020 11:34 AM
 */
public class HashMapCanBeSee {

    //one thread create a hashMap can another see?

    public static void main(String[] args) throws InterruptedException {
        HashMap hashMap = new HashMap();

        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                hashMap.put("name","zhaoxu");
            }
        });
        thread.start();
        thread.join();
        System.out.println(hashMap.get("name"));





    }

}
