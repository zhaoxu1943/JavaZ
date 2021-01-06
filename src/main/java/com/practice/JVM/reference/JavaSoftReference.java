package com.practice.JVM.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @author zhaoxu
 * @version 1.0
 * @className JavaSoftReference
 * @description 探究软引用
 * 如果一个对象只具有软引用，则内存空间充足时，垃圾回收器就不会回收它；
 * 如果内存空间不足了，就会回收这些对象的内存。
 * 只要垃圾回收器没有回收它，该对象就可以被程序使用。
 *
 * 软引用可用来实现内存敏感的高速缓存。
 * @date 2019/12/30 16:15
 **/
public class JavaSoftReference {
    public static void main(String[] args) {
        // 强引用
        String strongReference = new String("abc");
        // 软引用
        String str = new String("abc");
        Object o = new Object();
        //对强引用类型创建软引用
        SoftReference<String> softReference = new SoftReference<>(str);
        SoftReference<Object> softObject = new SoftReference<>(o);


        //软引用可以和一个引用队列联合使用,如果软引用锁引用的对象被垃圾回收,JVM就会把这个软引用
        //与之关联的引用队列中
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String str1 = new String("123");
        SoftReference<String> softReference1 = new SoftReference<>(str1,referenceQueue);

        //也就是说，垃圾收集线程会在虚拟机抛出OutOfMemoryError之前回收软引用对象，
        // 而且虚拟机会尽可能优先回收长时间闲置不用的软引用对象。
        // 对那些刚构建的或刚使用过的**"较新的"软对象会被虚拟机尽可能保留**，
        // 这就是引入引用队列ReferenceQueue的原因。
        //
        //作者：零壹技术栈
        //链接：https://juejin.im/post/5b82c02df265da436152f5ad
        //来源：掘金
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        //应用场景
        //浏览器的后退按钮。按后退时，这个后退时显示的网页内容是重新进行请求还是从缓存中取出呢？这就要看具体的实现策略了。
        //
        //如果一个网页在浏览结束时就进行内容的回收，则按后退查看前面浏览过的页面时，需要重新构建；
        //如果将浏览过的网页存储到内存中会造成内存的大量浪费，甚至会造成内存溢出。
        //
        //这时候就可以使用软引用，很好的解决了实际的问题
        //

        //实现方式
        //首先强引用调用页面
        //之后使用软引用建立软引用
        //回退时,如果内存充足,软引用还在,就直接访问
        //如果被回收了,就重新加载,也不会造成OOM

    }
}
