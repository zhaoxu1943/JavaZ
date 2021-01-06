package com.practice.JavaConcurrent.JavaThreadSafe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName WrongInit
 * @Description 多线程容器初始化时机不对,导致读取空指针,可以通过join(),或者选择合适的时机初始化来解决
 * @Author zhaoxu
 * @Date 2019/11/19 13:44
 * @Version 1.0
 **/
public class WrongInit {

    private Map<Integer, String> students;

    //这里如果不加thread.join()
    //因为线程启动需要时间,可能容器还没有初始化好就调用 会产生空指针
    public WrongInit() throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                students = new ConcurrentHashMap<>();
                students.put(1,"赵旭");
                students.put(2,"赵大喜");
                students.put(3,"赵晓旭");
                students.put(5,"都会塞");
            }
        });
        thread.start();
        thread.join();
    }

    public Map<Integer,String> getStudents () {
        return students;
    }

    public static void main(String[] args) throws InterruptedException{
        WrongInit wrongInit = new WrongInit();
        System.out.println(wrongInit.getStudents().get(5));
    }


}
