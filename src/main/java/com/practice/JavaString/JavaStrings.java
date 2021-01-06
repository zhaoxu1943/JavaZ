package com.practice.JavaString;


import java.util.ArrayList;
import java.util.List;
//  uintx StringTableSize = 60013  {product}
//通过-XX:+PrintStringTableStatistics参数，还可以得到当前JVM中StringTable的统计信息，
//字符串驻留（String interning）是字符串常量池产生的根本原因。英文维基上提供了非常好的解释，大意如下：
//
//所谓字符串驻留，是指在系统中，对每个字面量唯一的字符串，都只保留唯一的一份副本，称作“驻留量”（intern），并且它们都是不可变的。这些彼此不同的字符串被存储在字符串常量池中。
//各编程语言有各自的方法来取得字符串常量池中的驻留量，或者将一个字符串驻留，比如Java中的String.intern()。在Java中，所有编译期能确定的字符串也都会自动驻留。
//
//不仅字符串可以驻留。例如在Java中，[-128,127]区间内的Integer被缓存在内部类IntegerCache中，这个类就相当于整形常量池。在该区间内两个数值相同的整形值，在自动装箱后实际上指向堆内的同一个Integer对象（也就是驻留量），可以参考Integer.valueOf()方法的源码。
//字符串驻留是设计模式中的享元模式（flyweight pattern）的典型实现，这里就不展开描述了。
//
//作者：LittleMagic
//链接：https://www.jianshu.com/p/6bee67a7f6ce
//来源：简书
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 字符串常量池引用还是对象
// 对于字符串字面量（当然也包括常量表达式），常量池里会直接保存String对象。如果是编译期不能确定的字符串，调用intern()方法会使得常量池中保存对堆内String对象的引用，而不会在常量池内再生成一个对象。
//  对象在哪,
//字符串常量池在堆中,new的String 也在堆中
//  如何工具看heap都有啥
//  jmap
//  ,new的时候会在pool放一个不
//会,在栈中和String常量池各一个
public class JavaStrings {


    //可变性
    //关于String 源码 private final char value[];
    //String类中使用final修饰的char数组保存,所以String对象是不可变的
    //而StringBuffer与StringBuilder也是用字符串数组保存,但是没有用final修饰,所以这两个都是可变的

    //线程安全性
    //String中的对象是不可变的,可以理解为常量,线程安全
    //StringBuffer 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。
    //StringBuilder 并没有对方法进行加同步锁，所以是非线程安全的。

    //性能
    //每次对 String 类型进行改变的时候，都会生成一个新的 String 对象，然后将指针指向新的 String 对象。
    //StringBuffer 每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象并改变对象引用。
    //相同情况下使用
    //StirngBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，
    //但却要冒多线程不安全的风险。(那就是就用Buffer就完事了)

    public  String testStringBuffer(String string)
    {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append("connect");
        return stringBuffer.toString();
    }


    public  String testStringBuilder(String string)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("connect");
        return stringBuilder.toString();
    }


    public static void main(String[] args) throws InterruptedException {

        String s ;
        s ="zhaoux";
        System.out.println(s);
//        JavaStrings javaStrings = new JavaStrings();
//        String testString = "test";
//        //这里也能说明,String同基本类型一样,值传递时,传入方法后,自身的值是不变的
//        String stringBuffer = javaStrings.testStringBuffer(testString);
//        System.out.println(testString);
//        String stringBuilder = javaStrings.testStringBuilder(testString);
//        System.out.println(testString);

        //两个String的考试题
       // stringTest();
        //stringTest1();

        //String内存区域
        //stringOOM();
       // Thread.sleep(20000);
//        String s1 = new String("a");  //#1
//        s1.intern();                   // #2
//        String s2 = "a";               // #3
//        System.out.println(s1 == s2);
//        Thread.sleep(30000);
//        String s3 = s2 + s2;
//        s3.intern();
//        System.out.println("已操作");// #5
//        Thread.sleep(10000);
        //String s4 = "aa";              // #6
       // System.out.println(s3 == s4);

        //JVM书中的代码,我们按jdk8前后分析一下
        //之前是常量池在永久代,那么第一个字符串,左边是方法区常量池,右边是堆false,第二个依然是方法区与堆
        //而jdk8中,首先str1在堆中新建,加入常量池之后,将自身引用加入,所以说左边是堆中的引用地址,右边是堆中的引用地址,true
        //第二句,str2这个java在堆中新建,但是java在常量池本身是有的,所以左边返回常量池引用,右边是堆中地址,false

        //即首次出现原则,常量池中,记录首次出现的实例的引用!
        String str1 =new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern()==str2);

    }



    public  static void whereIsString() {
//        String s1 = new String("a");   // #1
//        s1.intern();                   // #2
//        String s2 = "a";               // #3
//        System.out.println(s1 == s2);
//
//        String s3 = s2 + s2;           // #4
//        s3.intern();                   // #5
//        String s4 = "aa";              // #6
//        System.out.println(s3 == s4);

    }




    //先记录几个jvm参数
    //-Xms8m  java堆大小 -Xmx8m 最大堆大小 一样说明不扩展
    // -XX:PermSize=8m -XX:MaxPermSize=8m 已经移除的永久代
    // -XX:+UseParallelGC //
    // -XX:+PrintGCDetails 打印gc细节
    // -XX:+PrintStringTableStatistics 打印字符串常量池信息
    // -XX:-UseGCOverheadLimit 关闭检查 JDK7和8均报超出GC临界限制。在HotSpot中，一旦JVM检查到用98%以上的时间来GC，而回收了少于2%的堆空间
    //抛出OOM Java heap space 说明了字符串对象在heap区
    public  static void stringOOM() {
        // 使用List保持引用，避免常量池被GC
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    public static void stringTest() {
        //当执行第一句时，JVM会先去常量池中查找是否存在HelloJavaZ，
        // 当存在时直接返回常量池里的引用；当不存在时，会在字符创常量池中创建一个对象并返回引用。
        String str1 = "HelloJavaZ";
        //当执行第二句时，同样的道理，由于第一句已经在常量池中创建了，
        // 所以直接返回上句创建的对象的引用,不会创建新的对象。
        String str2 = "HelloJavaZ";
        //String.java中重写了,不是调用的Object.java中的那个了
        str1.equals(str2);
        //此方式在堆内存创建对象
        String str3 = new String("HelloJavaZ");
        //由于"Hello"和"JavaZ"都是常量，编译时，第二句会被自动编译为‘String str6 = "HelloJavaZ";
        String str4 = "Hello";
        String str5 = "JavaZ";
        String str6 = "Hello" + "JavaZ";
        //第四句执行时，JVM会在堆（heap）中创建一个以str4为基础的一个StringBuilder对象，
        // 然后调用StringBuilder的append()方法完成与str5的合并，
        // 之后会调用toString()方法在堆（heap）中创建一个String对象，
        // 并把这个String对象的引用赋给str7
        String str7 = str4 + str5;

        System.out.println("str1 == str2 result: " + (str1 == str2));
        //true,返回运行时常量池中的同一个常量的引用
        System.out.println("str1 == str3 result: " + (str1 == str3));
        //false,str1返回常量池中的引用,而 str3返回栈中的引用
        System.out.println("str1 == str6 result: " + (str1 == str6));
        //true,返回运行时常量池中的同一个常量的引用
        System.out.println("str1 == str7 result: " + (str1 == str7));
        //false,str7在堆中
        System.out.println("str1 == str7.intern() result: " + (str1 == str7.intern()));
        //true,如果常量池中存在当前字符串, 就会直接返回常量池中当前字符串的引用
        // 如果常量池中没有此字符串, 会将此字符串放入常量池中后, 再返回常量字符串的引用
        System.out.println("str3 == str3.intern() result: " + (str3 == str3.intern()));
        System.out.println("str1 == str3.intern() result: " + (str1 == str3.intern()));
        //false 左边是堆中的引用 右边是运行时常量池中的引用
        System.out.println(str7.intern());
        System.out.println(str3.intern());


        //这里如果常量池中有, String b = a.intern()这样仅仅是把常量池中的
        //引用给了b 那么没有新建对象
        String a = new String(new char[] { 'a', 'b', 'c', 'd' });
        String b = a.intern();
        if (b == a) {
            System.out.println("b被加入了字符串池中，没有新建对象");
        } else {
            System.out.println("b没被加入字符串池中，新建了对象");
        }



    }


    public static void stringTest1() {
        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb)
            //true 常量池
            System.out.println("aa==bb");
        if (a == b)
            //false 堆中不同引用
            System.out.println("a==b");
        if (a.equals(b))
            //true String中重写了
            System.out.println("aEQb");
        if (42 == 42.0) {
            //int和double false
            System.out.println("true");
        }
    }
}
