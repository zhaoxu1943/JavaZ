package com.practice.JavaBasicFeatures.JavaReflect;

public class ReflectSubClass extends ReflectSuperClass{

    private String subName;
    protected int subAge;
    public Integer subBirthday=2;


    public ReflectSubClass(){
        System.out.println("subclass constructor call!");
    }

    public void printSub(String name){
        System.out.println(name +"subClass method called!");
    }


    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getSubAge() {
        return subAge;
    }

    public void setSubAge(int subAge) {
        this.subAge = subAge;
    }

    public Integer getSubBirthday() {
        return subBirthday;
    }

    public void setSubBirthday(Integer subBirthday) {
        this.subBirthday = subBirthday;
    }
}
