package com.practice.JavaBasicFeatures;

import java.lang.reflect.Method;

/**
 * @author zhaoxu
 * @className JavaAnnotationTest
 * @projectName JavaConcentration

 * @date 3/26/2020 10:10 AM
 */
public class JavaAnnotationTest {

    //自定义注解,看起来是注解的属性,本质上还是接口的方法.
    @JavaAnnotation(myName = "zhaoxu")
    public static void main(String[] args) throws NoSuchMethodException{
        Class clazz = JavaAnnotationTest.class;
        Method method = clazz.getMethod("main", String[].class);
        JavaAnnotation javaAnnotation = method.getAnnotation(JavaAnnotation.class);
        System.out.println(javaAnnotation.myName());
        System.out.println();
    }
}
