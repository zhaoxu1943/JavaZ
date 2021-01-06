package com.practice.JavaGenerics;

/**
 * @ClassName JavaGenericsInterfaceImpl
 * @Description 子类实现泛型接口
 * @Author zhaoxu
 * @Date 2019/11/26 11:02
 * @Version 1.0
 **/

//第一种情况,在接口中明确类型参数变量
//public class JavaGenericsInterfaceImpl implements JavaGenericsInterface<String> {
//    @Override
//    public void show(String s) {
//        System.out.println(t);
//    }
//}

//第二种情况,依然是泛型,需要传递参数进来
public class JavaGenericsInterfaceImpl<T> implements JavaGenericsInterface<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}