package com.practice.JavaBasicFeatures;

import com.practice.JavaBasicFeatures.JavaExtends.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName JavaInnerClass
 * @Description 探究内部类
 * 内部类定义在类的内部，可以方便访问外部类的变量和方法，并且和其它类进行隔离。
 * 如果类使用了private修饰符，说明是个内部类。内部类的上一级是外部类，那么对应的有四种访问控制修饰符：本类(private)，同包(default)，父子类(protected)，任何位置(public)
 * 当一个内部类使用了private修饰后，只能在该类的外部类内部使用。
 * @Author zhaoxu
 * @Date 2019/11/21 13:07
 * @Version 1.0
 **/
public class JavaInnerClass {

    private static String KEYWORD = "内部类!";

    private static String KEYWORD_STATIC_INNER_CLASS = "这是一个静态内部类";

    private ArrayList<String> arrayList = new ArrayList<String>();

    public static void main(String[] args) {
        //比如new一个线程时使用的匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                //1.内部类可以访问该类域中的所有变量,包括private的,如KEYWORD这个private变量
                System.out.println(KEYWORD+"我是一个匿名内部类,我实现了Runnable接口");
            }
        }).start();


    }



     /**
     * @Author zhaoxu
     * @Description 内部类示例
     * @Date 13:45 2019/11/21
     * @Param
     * @return
     **/
     //外部类即普通的类不能使用 private protected 访问权限符来修饰,只能是public
         //但是内部类可以

    private class MyInnerClass {

        //内部类不能有静态的声明,也就是说不能有main方法
         //这里直接使用了外部类中的private数组
         //原因:外部类创建一个内部类对象时,内部类对象可以得到一个指向外部类对象的引用,靠这个引用去访问
         //内部类是一种编译器行为,在编译时会编译成一个名字叫 外部类$内部类的文件,交给JVM
         void getItem(int index) {
             String string = arrayList.get(index);
         }
    }



     /**
     * @Author zhaoxu
     * @Description //一个静态内部类
      *
      *Java集合类HashMap内部就有一个静态内部类Entry。Entry是HashMap存放元素的抽象，
      * HashMap内部维护Entry数组用了存放元素，但是Entry对使用者是透明的。像这种和外部类关系密切的，且不依赖外部类实例的，都可以使用静态内部类。
      *
      *
      * {@link java.util.HashMap}
     * @Date 21:55 2019/11/21
     * @Param
     * @return
     **/
     public static class StaticInner {
         public void print() {
             System.out.println(KEYWORD_STATIC_INNER_CLASS);
         }
     }



     /**
     * @Author zhaoxu
     * @Description //一个成员内部类,不是静态的就是成员的
     * @Date 2:00 2019/11/22
     * @Param
     * @return
     **/
    public class MemberInner {
        public void print() {
            System.out.println("我是一个成员内部类!");
        }
    }



     /**
     * @Author zhaoxu
     * @Description 方法中的类,局部类,如果方法中的局部类要访问方法的参数,那么方法参数一定得final修饰,不然报错
     * @Date 2:06 2019/11/22
     * @Param
     * @return
     **/
     public void test(final int c) {
         final int d = 1;

         class InnerLocal {
             public void print() {
                 System.out.println(c);
                 System.out.println(d);
             }
         }
     }

    public static void testStatic(final int c) {
        final int d = 1;

        class InnerLocalStatic{
            public  void print() {
                //定义在静态方法中的局部类不可以访问外部类的实例变量
                //System.out.println(b);
                System.out.println(c);
                System.out.println(d);
            }
        }
    }

}
