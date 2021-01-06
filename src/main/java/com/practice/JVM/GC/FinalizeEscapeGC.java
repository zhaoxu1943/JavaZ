package com.practice.JVM.GC;

/**
 * @author zhaoxu
 * @version 1.0
 * @className FinalizeEscapeGC
 * @description 演示对象的自我救赎
 * @date 2019/12/10 13:47
 **/
public class FinalizeEscapeGC {

    //声明成了一个类对象
      public static  FinalizeEscapeGC finalizeEscapeGC = null;

    @Override
    protected void finalize() throws Throwable {
        //进行自救
        super.finalize();
        FinalizeEscapeGC.finalizeEscapeGC = this;
        print("完成自救!");
    }

    public static void main(String[] args) throws InterruptedException{
        finalizeEscapeGC = new FinalizeEscapeGC();
        finalizeEscapeGC = null;
        //这里new出来的对象失去了引用,要被GC了
        System.gc();
        //执行了GC,由于@Override了finalize所以有必要执行,这个要被回收的对象执行了重写的finalize,又把自己赋值给了类变量
        //finalize的低优先级,等一会
        Thread.sleep(5000);
        if (finalizeEscapeGC != null) {
            //救赎成功和之前没有区别,除了已经不能再执行finalize
            print("完成自我救赎!我还活着!");
        }else{
            print("大业未成!");
        }


        //第二次,sleep5s执行,验证finalize一生只有一次
        Thread.sleep(5000);
        //这里的代码和上面的一样,指向的对象又被释放了
        finalizeEscapeGC =null;
        //但是这里判断已经执行过了finalize,所以没有必要执行
        System.gc();
        Thread.sleep(15000);
        if (finalizeEscapeGC != null) {
            print("完成自我救赎!我还活着!");
        }else{
            print("大业未成!");
        }



    }

    public static void print(String s) {
        System.out.println(s);
    }

}
