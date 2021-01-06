package com.practice.JavaGenerics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName JavaGenerics
 * @Description 理解java泛型
 *Java泛型设计原则：只要在编译时期没有出现警告，那么运行时期就不会出现ClassCastException异常.
 *
 * 泛型：把类型明确的工作推迟到创建对象或调用方法的时候才去明确的特殊的类型
 *
 * 泛型是提供给javac编译器使用的，它用于限定集合的输入类型，让编译器在源代码级别上，即挡住向集合中插入非法数据。
 * 但编译器编译完带有泛形的java程序后，生成的class文件中将不再带有泛形信息，以此使程序运行效率不受到影响，这个过程称之为“擦除”。
 *
 * @Author zach
 * @Date 2019/11/26 1:08
 * @Version 1.0
 **/
/*
    1:把泛型定义在类上
    2:类型变量定义在类上,方法中也可以使用
 */
public class JavaGenerics<T> {

    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }


    //定义泛型方法,泛型是先定义后使用的

    public <T> void show(T t) {
        System.out.println(t);
    }


    //java类型通配符,?表示可以匹配任何类
    //只能调用与对象无关的方法，不能调用对象与类型有关的方法
    //比如add就不能用,不知道要add进去什么类型,编译报错
    public void test(List<?> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    //使用泛型方法也可以实现与通配符相同的结果
    public <T> void  test2(List<T> t) {
    }

    //java设定通配符上限
    //我想接收一个List集合，它只能操作数字类型的元素【Float、Integer、Double、Byte等数字类型都行】，怎么做？？？
    //
    //我们学习了通配符，但是如果直接使用通配符的话，该集合就不是只能操作数字了。因此我们需要用到设定通配符上限
    //这样继承Number就意思是只能装载本身或者子类
    public static void testUp(List<? extends Number> list) {
    }

    //设定通配符下限,传递进来的只能是Number或Number的父类
    public static void testDown(List<? super Number> list) {
    }




    public static void main(String[] args) {

        //使用类泛型
        JavaGenerics<Integer> javaGenerics =new JavaGenerics<>();
        /**
         * 如果我在这个对象里传入的是String类型的,它在编译时期就通过不了了.
         */
        javaGenerics.setObject(123456);
        int i =javaGenerics.getObject();
        System.out.println(i);

        //使用方法泛型,参数写什么类型,就是什么类型
        javaGenerics.show("hello");
        javaGenerics.show(132L);


        List<Integer> list = new LinkedList<>();
        testUp(list);


        //整个称为ArrayList<E>泛型类型
        //整个ArrayList<Integer>称为参数化的类型
        ArrayList<Integer> arrayList = new ArrayList();


    }

}
