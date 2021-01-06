package com.practice.JVM.bytecode;

/**
 * @author zhaoxu
 * @version 1.0
 * @className bytecode

 * @date 2019/12/23 9:24
 **/
public class TestClass {
    private int m;

    public TestClass() {
    }

    public int inc() {
        //二维数组的初始化
        Integer[][] strings = {{1,2}, {2, 3}, {4, 5}};
        return m +1;
    }
}
