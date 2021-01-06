package com.practice.JavaKeywords;

/**
 * @ClassName JavaFinal
 * @Description 探究final
 *
 * 当类被修饰为final,方法的内联 inline开始作用
 * 内联（inline）在Java中就是编译器为程序做的一种优化操作。
 * 就是JVM的方法调用
 * 方法的调用和方法执行绝对不是一回事
 *这点在我去理解AspectJ的call和execution的时候，体会尤为深刻
 *方法调用阶段唯一的任务就是确定被调用方法的版本，不会涉及方法内部的具体运行过程
 *我们都非常熟悉一个.java文件在被编译器编译后得到了一个对应的.class文件
 * 而方法的信息对应常量池入口地址都存在在一个method_info表中，同时这里也包含了access_flags，也就是编译器如何对final修饰的内容进行检查
 *
 *
 *
 *
 * @Author zhaoxu
 * @Date 2019/11/21 12:55
 * @Version 1.0
 **/
    public final class JavaFinal {

        //当类声明为final,类中的方法自动声明为final,因为他们不会再被重写了
        //当类声明为final,它不能被子类继承
        //这个类不想在关系结构上做出任何的改变，也不希望有任何人可以继承自这个类

        //引用类型来说，如果有final修饰一个引用类型变量，
        // 不是说明这个引用类型指向的实际地址的对象不可变，而是说这个引用不能再指向其他地址的对象，而对象本身是可以改变的
        //也很好理解,final的是引用,自然是不能变的,效果就是指向的地址不变
        public String javaFinal ="类声明为final,虽然方法都被声明为final,但实例变量不是";
        //final来修饰一个基本数据类型,那么它不会变
        public final String javaFinal1 = "当实例变量声明为final,不可修改!";

        /**
         * @Author zhaoxu
         * @Description 当类为final,类中的方法也是final
         * final修饰方法，如果从设计（Design）的角度去考虑，如果类之间体现了继承关系，
         * 那么final 修饰的方法则不能被子类重写或覆盖。如果没有体现继承关系，就从效率的角度考虑
         * @Date 12:59 2019/11/21
         * @Param
         * @return
         **/
        final void commit(final int x, final int y) {
            System.out.println("我是一个final方法!");
        }

}
