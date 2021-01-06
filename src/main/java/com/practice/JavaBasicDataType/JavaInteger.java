package com.practice.JavaBasicDataType;

/**
 * @ClassName JavaInteger
 * @Description 探究Integer
 *
 * Integer.class在装载（Java虚拟机启动）时，其内部类型IntegerCache的static块即开始执行，实例化并暂存数值在-128到127之间的Integer类型对象。
 * 当自动装箱int型值在-128到127之间时，即直接返回IntegerCache中暂存的Integer类型对象。
 *
 * 解决方法
 * 那么就不要用==，直接用equals()
 * @Author zhaoxu
 * @Date 2019/12/6 0:41
 * @Version 1.0
 **/
public class JavaInteger {
    public static void main(String[] args) {
        Integer i = 127;
        Integer j = 127;
        System.out.println(i == j);
        System.out.println(i+" "+j+" "+System.identityHashCode(i)+" "+System.identityHashCode(j));
        Integer m = 128;
        Integer n = 128;
        System.out.println(m == n);
        System.out.println(m+" "+n+" "+System.identityHashCode(m)+" "+System.identityHashCode(n));
        //从128开始a.b不再相等



        Integer integer =0xFFFFFFFF;
        System.out.println(integer);
    }
}
