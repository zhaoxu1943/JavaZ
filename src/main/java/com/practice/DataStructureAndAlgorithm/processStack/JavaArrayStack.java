package com.practice.DataStructureAndAlgorithm.processStack;

/**
 * 数组实现栈
 * @author zhaoxu
 * @className JavaArrayStack
 * @projectName JavaConcentration
 * @date 2020/9/18 9:59
 */
public class JavaArrayStack implements ZStacK{

    /**
     * 使用数组实现栈
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private int[] arr ;
    private int size;

    /**
     * 初始化栈的容量
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public JavaArrayStack(int capacity) {
        arr = new int[capacity];
        size = 0;
    }


    /**
     * pop
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    @Override
    public int pop() {
        int pop;
        if (size<=0) {
            throw new IllegalStateException("Stack容量为:"+size+"无法出栈");
        }else {
            //进行正常弹栈操作,最后一个元素出栈
            pop = arr[size-1];
            arr[size-1]=0;
        }
        size--;
        return pop;
    }

    /**
     * push
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    @Override
    public void push(int element) {
        if (size>=arr.length) {
            //进行数组的扩容
            resize();
        }
        arr[size]=element;

        size++;
    }








    /**
     * peek
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    @Override
    public int peek() {
        int peek;
        if (size<=0) {
            throw new IllegalStateException("Stack容量为:"+size+"无法peek");
        }else {
            peek = arr[size-1];
        }
        return peek;
    }





    /**
     * 栈的打印,仅打印栈中元素
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    @Override
    public void printStack() {
        for (int i = 0; i <size ; i++) {
            System.out.println(arr[i]);
        }
    }






    /**
     * 数组扩容
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private void resize() {
        int[] doubleSizeArr = new int[arr.length*2];
        System.arraycopy(arr,0,doubleSizeArr,0,arr.length);
        arr = doubleSizeArr;
    }





    /**
     * 测试用例
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void main (String[] args) {
        JavaArrayStack stack = new JavaArrayStack(3);

        System.out.println("-------push测试--------");
        stack.push(32132);
        stack.push(3213);
        stack.push(221);
        stack.printStack();
        System.out.println("-------resize测试--------");
        stack.push(555);
        stack.push(555);
        stack.push(555);
        stack.push(555);
        stack.push(555);
        stack.push(555);
        stack.push(556);
        stack.printStack();
        System.out.println("-------peek测试--------");
        System.out.println("peek:"+stack.peek());

        System.out.println("-------pop测试--------");
        System.out.println("pop:"+stack.pop());
        stack.printStack();
    }








}
