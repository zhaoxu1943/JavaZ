package com.practice.JVM.OOM;

/**
 * @author zhaoxu
 * @version 1.0
 * @className StackOverFlow

 * @date 2019/12/10 9:59
 * VM args -Xss128k
 **/
public class StackOverFlow {
    private  int stackLength;

    //在递归时,每一个引用都是有有效的,才能继续下次递归,那么就会导致栈溢出
     void stackLeak(){
       stackLength++;
       stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackOverFlow stackOverFlow = new StackOverFlow();
        stackOverFlow.stackLeak();
    }


}
