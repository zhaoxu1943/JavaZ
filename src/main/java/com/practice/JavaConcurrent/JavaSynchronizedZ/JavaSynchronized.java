package com.practice.JavaConcurrent.JavaSynchronizedZ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName JavaSynchronized
 * @Description Synchronized的几种用法
 * @Author zhaoxu
 * @Date 2019/11/19 14:50
 * @Version 1.0
 **/
public class JavaSynchronized {

    private static int AVERAGE_AGE = 124;

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public JavaSynchronized(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws InterruptedException {

        JavaSynchronized javaSynchronized = new JavaSynchronized("zhaoxu", "123");

        new Thread(new Runnable() {
            @Override
            public void run() {
                javaSynchronized.swapStudentInfo(javaSynchronized);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                javaSynchronized.swapStudentInfo(javaSynchronized);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                javaSynchronized.swapStudentInfo(javaSynchronized);
            }
        }).start();

        Thread.sleep(1000);
        System.out.println("name= " + javaSynchronized.getName());
        System.out.println("age= " + javaSynchronized.getAge());


        float s1 = calculator(3, 4, "+");
        System.out.println("s = " + s1);
        float s2 = calculator(3, 4, "-");
        System.out.println("s = " + s2);
        float s3 = calculator(3, 4, "*");
        System.out.println("s = " + s3);
        float s4 = calculator(3, 0, "/");
        System.out.println("s = " + s4);

    }

    /**
     * 首先是sychronized修饰方法
     * 一种是修饰实例方法,一种是修饰静态方法
     */

    //修饰实例方法,锁住了其对象实例
    public synchronized JavaSynchronized swapStudentInfo(JavaSynchronized javaSynchronized) {
        String ageSave = javaSynchronized.getAge();
        javaSynchronized.setAge(javaSynchronized.getName());
        javaSynchronized.setName(ageSave);
        return javaSynchronized;
    }


    //修饰静态方法,锁住的是类
    public synchronized static float calculator(float i, float j, String operator) {

        float s = 0;
        switch (operator) {
            case "+":
                s = i + j;
                break;
            case "-":
                s = i - j;
                break;
            case "*":
                s = i * j;
                break;
            case "/":
                if (j == 0) {
                    System.out.println("除数不能为0");
                } else {
                    s = i / j;
                    break;
                }
        }
        return s;
    }


    /**
     * 首先是sychronized修饰同步代码块
     */

        //锁住的是实例对象
    //synchronized (this)
    public String take() throws InterruptedException {
        Queue<String> buffer = new LinkedList<String>();
        synchronized (this) {
            while (buffer.isEmpty()) {
                wait();
            }
            return buffer.remove();
        }
    }

    //锁住任意对象
    public void lockObject () {
        Object o = new Object();
        synchronized (o) {
            System.out.println("锁住的是o!");
        }
    }

    //锁住的是类,类锁与实例方法的实例锁不相互影响
    public void lockClass() {
        synchronized (JavaSynchronized.class) {
            System.out.println("锁住的是类");
        }
    }




}