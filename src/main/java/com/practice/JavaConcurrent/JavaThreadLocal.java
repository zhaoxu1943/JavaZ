package com.practice.JavaConcurrent;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

import static cn.hutool.core.date.DatePattern.*;

/**
 * 场景1，ThreadLocal 用作保存每个线程独享的对象，为每个线程都创建一个副本，这样每个线程都可以修改自己所拥有的副本, 而不会影响其他线程的副本，确保了线程安全。
 *
 * <p>场景2，ThreadLocal 用作每个线程内需要独立保存信息，以便供其他方法更方便地获取该信息的场景。每个线程获取到的信息可能都是不一样的，前面执行的方法保存了信息后，后续方法可以通过
 * ThreadLocal 直接获取到，避免了传参，类似于线程中的全局变量的概念。
 *
 * @author zhaoxu
 * @className JavaThreadLocal
 * @projectName JavaConcentration
 * @date 2020/12/30 9:36
 */
public class JavaThreadLocal {

  // * It is recommended to create separate format instances for each thread.
  // * If multiple threads access a format concurrently, it must be synchronized
  //声明为static实现了虽然实现线程复用,但出现了线程安全问题
    //表现出出现了相同的时间,理论上应该是100个不同的时间
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(NORM_TIME_PATTERN);

  public static void main(String[] args) {
    for (int i = 0; i <100; i++) {
        //此时的i属于主线程,循环外的变量

        //转为循环内final变量,这里不用显示的声明,编译器自动声明final
        int  finalI = i;
        new Thread(()->{
        //Lambda表达式是运行在一个独立的子线程中,
        //当这个线程运行时,它实际上拿到的是一个原始变量的副本(一个拷贝)
        //由于线程相隔,基本数据类型在线程私有的栈上分配
        // 故主线程中的循环值i对另一个线程不可见
        //这里复制一份就可以了
        String date = new JavaThreadLocal().getFormatDateThreadLocal(finalI);
        System.out.println(Thread.currentThread().getName()+date);
        }).start();
    }

  }
    /**
     * synchronized为公共simpleDateFormat对象加锁
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public  String getFormatDateSyn(int sec){
        Date date = new Date(1000*sec);
        synchronized (JavaThreadLocal.class) {
            return simpleDateFormat.format(date);
        }
    }


    /**
     * 即便任务再多，最终也只会有和线程数相同的 simpleDateFormat 对象
     * 每个线程拥有自己独立的simpleDateFormat副本,是线程安全的
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public  String getFormatDateThreadLocal(int sec){
        Date date = new Date(1000*sec);
        SimpleDateFormat simpleDateFormat  =ThreadSafeFormatter.simpleDateFormatThreadLocal.get();
        return simpleDateFormat.format(date);
    }


}


class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        /**
         * 返回此线程局部变量的当前线程的“初始值”。
         * 除非线程先前调用了{@link #set} *方法（
         * 在这种情况下为{@code initialValue}方法），
         * 否则线程将在第一次使用{@link #get} *方法访问变量时调用此方法。
         *不会为该线程调用。通常，此方法最多每个线程调用一次，
         * 但是在随后依次调用{@link #remove}和{@link #get}的情况下，
         * 可以再次调用该方法。 * *
         * <p>此实现仅返回{@code null};
         * 如果程序员希望线程局部变量的初始值不是{@code null}，
         * 则必须将{@code ThreadLocal}子类化，
         * 并重写此方法。
         * 通常，将使用*匿名内部类。
         * 返回此线程本地的初始值
         */
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_TIME_PATTERN);
        }
    };
}
