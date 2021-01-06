package com.readbooks.efftectiveJava.rules1;

/**
 * @author zhaoxu
 * @className Rules1
 * @projectName JavaConcentration
 * @description 第一条:用静态工厂方法代替构造器
 * @date 4/17/2020 8:08 PM
 */
public class Rules1 {

    //我们可以通过更换参数顺序,假装有两个不同的构造函数
    //如下
    //不过也不推荐,太容易迷惑别人了,但是我们可以通过静态工厂方法起不同名字对他们做出区分
    public Rules1(String string,Integer integer) {
    }

    public Rules1(Integer integer,String string) {
    }

    public Rules1() {
    }

    public static void main(String[] args) {

        //Boolean静态工厂方法,将基础数据类型转为包装类型
        boolean b = false;
        Boolean b1= getBooleanInstance(b);
        System.out.println(b1);

        //很迷惑
        Rules1 rules1 = new Rules1(1,"abc");
        Rules1 rules2 = new Rules1("abc",1);

        //语义很清晰
        Rules1 rules3 = getRules1StringFirst();
        Rules1 rules4 = getRules1IntegerFirst();

    }


    public static Rules1 getRules1StringFirst() {
        return new Rules1(new String("abc"),new Integer(1));
    }
    public static Rules1 getRules1IntegerFirst() {
        return new Rules1(new Integer(1),new String("abc"));
    }

    //返回子类对象类型
    public static SubRules1 getSubRules1IntegerFirst() {
        return new SubRules1();
    }


    public static  Boolean getBooleanInstance(boolean b) {
        return b?Boolean.TRUE:Boolean.FALSE;
    }

}
