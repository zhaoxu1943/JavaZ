package com.practice.JavaBasicFeatures.JavaInterface;

//接口则是对行为进行抽象
//接口支持多继承
public interface Alibaba {

    //接口中的方法隐式声明成了public abstract,所以什么都不要加
    // 标准写法 void commit();
    //接口中的变量隐式声明成了 public static final,尽量不在接口中定义常量
    //如果非要定义,那么一定是与接口方法相关,且是整个应用的基础常量
    //标准写法 String COMPANY = "alibaba";

    String COMPANY = "alibaba";

    void learn();

    void improve();

     /**
     * @Author zhaoxu
     * @Description //JDK1.8中接口允许有默认实现
     * @Date 11:17 2019/11/20
     * @Param
     * @return
     **/
     //接口提供一个默认实现的方法，并且不强制实现类重写此方法
     //
     //默认方法使用default关键字来修饰
    default void codeMore() {
        System.out.println("code More,learn More.");
    }


}
