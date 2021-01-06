package com.practice.JavaBasicFeatures.JavaEqualsAndHashcode;

import java.io.Serializable;
import java.util.Objects;





public class EqualsAndHashcode implements Comparable , Serializable {


    private static final long serialVersionUID = 6098686988674803363L;

    public String name;

    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //    @Override
//    public boolean equals(Object o) {
//        throw new AssertionError("此类不允许使用equals()");
//    }

    //如果这个一个可以继承的类,根据里氏替换原则,一个类型的重要属性也将适用于其子类
    //boolean result = obj instanceof Class


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsAndHashcode)) return false;
        EqualsAndHashcode that = (EqualsAndHashcode) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

       @Override
    public String toString() {
        return "EqualsAndHashcode{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


    public static void main(String[] args) {
        EqualsAndHashcode equalsAndHashcode1 = new EqualsAndHashcode();
        equalsAndHashcode1.setAge(12);
        equalsAndHashcode1.setName("zhaoxu");
        EqualsAndHashcode equalsAndHashcode2 = new EqualsAndHashcode();
        equalsAndHashcode2.setAge(12);
        equalsAndHashcode2.setName("zhaoxu");
        boolean b  = equalsAndHashcode1.equals(equalsAndHashcode2);
        System.out.println(b);
    }
}

