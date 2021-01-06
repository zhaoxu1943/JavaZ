package com.practice.JavaBasicFeatures;


//java值传递问题
public class JavaParameterTransfer {

    //输出依然是BEA,非引用类型的String和基础类型传入方法不会改变原值
    //但是如果传递的是对象(引用类型) 那么因为传递的引用会指向同一个对象 所以会真正的改变对象
    public static void main(String[] args) {
        JavaParameterTransfer javaParameterTransfer = new JavaParameterTransfer();
        String str = "BEA";
        javaParameterTransfer.change(str);
        System.out.printf(str);
    }


    void change(String s) {
        s = s.replace('A','E');
        s = s.toLowerCase();

    }
}

