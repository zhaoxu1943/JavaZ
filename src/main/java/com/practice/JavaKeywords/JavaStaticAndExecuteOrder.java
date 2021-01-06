package com.practice.JavaKeywords;

/**
 * @ClassName JavaStatic
 * @Description 研究关键字static的用法
 * @Author zhaoxu
 * @Date 2019/11/20 12:30
 * @Version 1.0
 **/
public class JavaStaticAndExecuteOrder {

    //2、是否可以在static环境中访问非static变量？
    //static变量在Java中是属于类的，它在所有的实例中的值是一样的。
    //当类被Java虚拟机载入的时候，会对static变量进行初始化。
    // 如果你的代码尝试不用实例来访问非static的变量，编译器会报错，因为这些变量还没有被创建出来，还没有跟任何实例关联上
    //反言之 静态方法中,使用实例则可以访问实例对象
    //就是说static是类加载时候创建,这时还没有类的实例创建

    //4、静态方法里面能不能引用静态资源？
    //可以，因为都是类初始化的时候加载的，大家相互都认识。
    //
    //5、非静态方法里面能不能引用静态资源？
    //可以，非静态方法就是实例方法，那是new之后才产生的，那么属于类的内容它都认识。

    //第一种 修饰成员变量,称之为静态变量,不需要new类的实例,直接通过类名去访问
    //静态变量也称为类变量
    //类加载时完成初始化
    //内存中只有一个,JVM只会为它分配一次内存,处于方法区,一处变处处变
    //类的所有实例都可以共享
    //一般用于对象间共享数据
    //
    //初始值:有默认的初始化值
    //调用方式:类名调用,对象调用
    //内存位置:方法区
    //位置:在类中,方法外
    public static String KEYWORDS = "Static";
    public static int age = 12;

    //对比一下普通的实例变量(成员变量)
    //初始值:有默认的初始化值
    //调用方式:对象调用
    //内存位置:堆
    //位置:在类中,方法外
    public String instanceVariables = "Member variables";




    public JavaStaticAndExecuteOrder() {
        System.out.println("构造函数,在构造代码块后执行,且这俩一定是挨着的,创建一个对象,他俩挨着执行一次!");
    }

    //第二种 修饰成员方法,称之为静态方法,同样的不需要new类的实例,通过类名.方法直接调用
    public static void sayHello () {
        System.out.println("Hello"+KEYWORDS);
    }

    public static int changeNum(int i) {
        i=i+1;
        return i;
    }

    public static String changeString(String string) {
        //对比一下局部变量
        //初始值:没有,必须给值
        //调用方式:直接用
        //内存位置:栈
        //位置:在类中,方法内
        String newString = string + "change";
        return newString;
    }

    //顺便研究一下静态变量的值传递问题,结果证明,String和基础数据类型,进行传入方法的值传递时,不改变其原有的值.
    public static void main(String[] args) {
        JavaStaticAndExecuteOrder javaStaticAndExecuteOrder = new JavaStaticAndExecuteOrder();
        JavaStaticAndExecuteOrder javaStaticAndExecuteOrder1 = new JavaStaticAndExecuteOrder();

        //普通方法
        System.out.println("值传递前的值 " + KEYWORDS+"我是一个普通方法,我最后执行!");
        changeString(KEYWORDS);
        System.out.println("值传递后的值 " + KEYWORDS);
        System.out.println("值传递前的值 " + age);
        changeNum(age);
        System.out.println("值传递后的值 " + age);
    }

    //静态代码块
    static {
        System.out.println("静态代码块,在类加载时进行,且无论new多少个实例,只会执行一次,且第一个执行！");
    }

    //构造代码块
    {
        System.out.println("构造代码块,创建对象时运行,且优先于构造函数,new一个实例,执行一次");
    }
}
