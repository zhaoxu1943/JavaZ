package com.practice.JVM.reference;

import java.lang.ref.WeakReference;

/**
 * @author zhaoxu
 * @version 1.0
 * @className JavaWeakRef
 * @description 探究弱引用对象
 *弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。
 * 在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，
 * 不管当前内存空间足够与否，都会回收它的内存。
 * 不过，由于垃圾回收器是一个优先级很低的线程，因此不一定会很快发现那些只具有弱引用的对象。
 *
 * 即软引用在OOM即将抛出时回收,而弱引用一定会被GC回收
 *
 *
 * @date 2019/12/30 20:54
 **/
public class JavaWeakRef {

    public static void main(String[] args) {
        String str = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(str);

        //使用
        //注意：如果一个对象是偶尔(很少)的使用，并且希望在使用时随时就能获取到，
        // 但又不想影响此对象的垃圾收集，那么你应该用Weak Reference来记住此对象。
    }

}
