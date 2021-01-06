package com.practice.DataStructureAndAlgorithm.processStack;

import com.practice.DataStructureAndAlgorithm.processLinkedList.JavaLinkedList;
import com.practice.DataStructureAndAlgorithm.processLinkedList.SingleLinkedListNode;

/**
 * 使用链表作为物理结构实现栈
 *
 * @author zhaoxu
 * @className JavaLinkedListStack
 * @projectName JavaConcentration
 * @date 2020/9/19 22:35
 */
public class JavaLinkedListStack implements ZStacK {


    /**
     * 使用单链表作为储存结构
     *
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private JavaLinkedList linkedList;

    private int size;

    public JavaLinkedListStack() {
        linkedList = new JavaLinkedList();
        size = 0;
    }

    /**
     * pop
     *
     * @return
     * @throws
     * @author zhaoxu
     */
    @Override
    public int pop() {
        int pop;
        if (size <= 0) {
            throw new IllegalStateException("Stack容量为:" + size + "无法弹栈");
        } else {
            SingleLinkedListNode singleLinkedListNode = linkedList.getLast();
            pop = singleLinkedListNode.getData();
            //删除元素
            linkedList.deleteNode(size-1);
        }
        size--;
        return pop;
    }

    /**
     * push
     *
     * @param element
     * @return
     * @throws
     * @author zhaoxu
     */
    @Override
    public void push(int element) {
        linkedList.insert(size, element);
        size++;
    }

    /**
     * peek
     *
     * @return
     * @throws
     * @author zhaoxu
     */
    @Override
    public int peek() {
        int peek;
        if (size <= 0) {
            throw new IllegalStateException("Stack容量为:" + size + "无法出栈");
        } else {
            SingleLinkedListNode singleLinkedListNode = linkedList.getLast();
            peek = singleLinkedListNode.getData();
        }
        return peek;
    }

    /**
     * 栈的打印
     *
     * @return
     * @throws
     * @author zhaoxu
     */
    @Override
    public void printStack() {
        linkedList.print();
    }



    /**
     * 测试用例
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void main (String[] args) {
        JavaLinkedListStack stack = new JavaLinkedListStack();

        System.out.println("-------push测试--------");
        stack.push(32132);
        stack.push(3213);
        stack.push(221);
        stack.printStack();
        System.out.println("-------容量测试,链表无需resize--------");
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
        stack.printStack();
        System.out.println("-------pop测试--------");
        System.out.println("pop:"+stack.pop());
        stack.printStack();
    }


}
