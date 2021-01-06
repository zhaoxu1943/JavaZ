package com.practice.JavaBasicFeatures.JavaExtends;

import com.practice.JavaBasicFeatures.JavaInterface.Alibaba;

/**
 * @Author zhaoxu
 * @Description //这是一个体现继承的父类
 * @Date 13:01 2019/11/21
 * @Param
 * @return
 **/
 //对于顶级类(外部类)来说，只有两种修饰符：public和默认(default)。因为外部类的上一单元是包，所以外部类只有两个作用域：同包，任何位置。
 // 因此，只需要两种控制权限：包控制权限和公开访问权限，也就对应两种控制修饰符：public和默认(default)。
     //当这里我去掉public,
 // 其他的package中的类去extends时,会报
 // 'com.practice.JavaBasicFeatures.JavaExtends.Animal' is not public in 'com.practice.JavaBasicFeatures.JavaExtends'. Cannot be accessed from outside package
//对于包内,这个类相当于public,对于包外,类不可见,即包访问权限

//'sleep()' is not public in 'com.practice.JavaBasicFeatures.JavaExtends.Animal'. Cannot be accessed from outside package
     //当类为public,那么类对任意位置可见,但是无权限修饰符的default 依然是包可见,其他包同private

 public class Animal  {

    public static String CLASS_INTRODUCE  = "各种动物的父类";

    //修饰词	本类	同一个包的类	继承类	其他类
    //private	√	    ×	            ×	×
    //无（默认）	√	    √	            ×	×
    //protected	√	    √	            √	×
    //public	√	    √	            √	√
    //————————————————
    //版权声明：本文为CSDN博主「一条肥鱼」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/asahinokawa/article/details/80777302

    protected static String animalType ="123";
    private int animalAge;



    protected void hr (Animal animal) {
        animal.sleep();
    }

     /**
     * @Author zhaoxu
     * @Description 构造函数不能被继承,不能重写@override,可以重载
     * @Date 13:02 2019/11/21
     * @Param
     * @return
     **/
    public Animal(String animalType, int animalAge) {
        this.animalType = animalType;
        this.animalAge = animalAge;
        System.out.println("调用了父类Animal的有参构造函数");
    }

    public Animal()
    {
    System.out.println("调用了父类Animal的有无参构造函数");
    }

    public void eat () {
        System.out.println(animalType +"eat");
    }

     void sleep () {
        System.out.println(animalType + "supersleep");
    }

    public void introduce () {
        System.out.println( "我是一只" + animalType + ",今年"+ animalAge+ "岁,大家好!");
    }

    public static void staticTest () {
        System.out.println( "这是父类中的static静态方法,测试子类是否可以调用,重写!");
    }


}
