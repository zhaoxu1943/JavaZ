package com.practice.JavaIO.AglieJavaC11;

import java.io.InputStream;

/**
 * Java通过保存在System.in和System.out中的流对象,分别表示标准输入/输出函数
 * System.in指向一个InputStream,我们看到这个in,其实是一个静态的InputStream,后面的read是InputStream抽象类的抽象方法
 * public final static InputStream in = null;
 *
 * 而System.out如源码所示,其实是 PrintStream对象
 *   public final static PrintStream out = null;
 *   printStream是一个专门的OutputStream 简化各种对象类型的写入
 *
 *   System.in和System.out都是字节流
 * @author zhaoxu
 * @className JavaSystemInAndOut
 * @projectName JavaConcentration
 * @date 2020/7/9 10:41
 */
public class JavaSystemInAndOut {
    public static void main(String[] args) throws Exception {
        int s = System.in.read();
        System.out.println(s);
    }
}
