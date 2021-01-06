package com.practice.JavaBasicFeatures.JavaReflect;

/**
 * @author zhaoxu
 * @className ReflectSubClass
 * @projectName JavaConcentration

 * @date 3/12/2020 11:58 AM
 */
public class ReflectSuperClass {

    public String superName;
    public int superAge;

    public ReflectSuperClass() {
        System.out.println("superClass constructor called!");
    }

    public void printSuper(){
        System.out.println("superClass method called!");
    }
}
