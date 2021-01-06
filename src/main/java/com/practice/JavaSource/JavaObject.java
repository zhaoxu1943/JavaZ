package com.practice.JavaSource;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;

/**
 * @ClassName JavaObject
 * @Description {@link Object}的研究
 *
 *
 * @Author zhaoxu
 * @Date 2019/11/23 1:12
 * @Version 1.0
 **/

public class JavaObject implements Cloneable {




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name = "JavaObject!";

    //Object.java隐式无参构造方法
    public JavaObject() {
        super();
    }

     /**
     * @Author zhaoxu
     * @Description
      <p><b>The actual result type is {@code Class<? extends |X|>}
            * where {@code |X|} is the erasure of the static type of the
         * expression on which {@code getClass} is called.</b> For
          * example, no cast is required in this code fragment:</p>
         *
       * <p>
        * {@code Number n = 0;                             }<br>
      * {@code Class<? extends Number> c = n.getClass(); }
      *   * </p>
     * @Date 10:27 AM 11/27/2019
     * @Param
     * @return
     **/
    public static void getClassTest(Class<? extends Number> clazz)   {
        //测试getClass()方法,
        //测试结果:无关于 call getClass()的参数,传的是哪个类
        //The actual result type is {@code Class<? extends |X|>}
        //父类Number is erasure
        Number n = 0L;
        clazz = n.getClass();
        System.out.println(clazz);
        System.out.println(n.getClass());
        System.out.println(clazz == n.getClass());
    }

    public static void cloneTest() {
        JavaObject javaObject = new JavaObject();
        try {
            //the clone() method in Object.java return a { Class Object} object
            JavaObject cloneJavaObject = (JavaObject)javaObject.clone();
            System.out.println(cloneJavaObject==javaObject);
            System.out.println(javaObject.clone().equals(javaObject));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //'clone()' has protected access in 'java.lang.Object'
        // clone() is a protected method
        //can invoked by subclass such as the instance of  JavaObject.class
        //but in subclass ,cant use protected method when using instance of superclass(Object.class)
//        Object o = new Object();
//        Object clone = o.clone();

    }

    public static void toStringTest(){
        JavaObject javaObject = new JavaObject();
        javaObject.setName("zhaoxu");
        javaObject.toString();
        System.out.println(javaObject.toString()+javaObject.hashCode());
    }

    public static void main(String[] args) {

        //这里传入int的包装类 Integer.class并不会报错
        getClassTest(Integer.class);
        //object.clone()
        cloneTest();
        //object.toString()
        toStringTest();

        JavaObject javaObject =new JavaObject();
        new  Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (javaObject) {
                    try {
                        javaObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaObject)) return false;
        JavaObject that = (JavaObject) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "JavaObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
