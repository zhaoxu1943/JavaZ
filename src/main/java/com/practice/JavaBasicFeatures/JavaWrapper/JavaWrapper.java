package com.practice.JavaBasicFeatures.JavaWrapper;

/**
 * @ClassName JavaWrapper
 * @Description java封装
 * @Author zhaoxu
 * @Date 2019/11/20 12:02
 * @Version 1.0
 **/
public class JavaWrapper {

    //私有字符串 MSG
    private String MESSAGE = "private";

    //Java的封装,即隐藏成员变量(private),与实现过程,仅提供对外的接口

    private String name;

    private String type;

    public JavaWrapper(String name, String type) {
        this.name = name;
        this.type = type;
    }

    //私有处理方法
    private String privateMethod(String name , String type){
        StringBuffer  stringBuffer = new StringBuffer();
        stringBuffer.append(name);
        stringBuffer.append(type);
        return stringBuffer.toString();
    }

    //公有方法来返回
    public String getAll(String name,String type){
        JavaWrapper javaWrapper = new JavaWrapper(name,type);
        return javaWrapper.privateMethod(name,type);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
