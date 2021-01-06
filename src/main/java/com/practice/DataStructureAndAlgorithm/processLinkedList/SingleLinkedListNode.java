package com.practice.DataStructureAndAlgorithm.processLinkedList;

import java.util.Objects;

/**
 * 链表(linked list)是一种在物理上非连续,非顺序的数据结构
 * 由若干节点(node)组成
 *
 * 本class node 为单向链表的node
 * 第一个节点被称为头结点,最后一个节点被称为尾节点,尾节点的next指针指向为空
 *
 * 对于数组,我们可以RandomAccess(),即按下表访问
 * 而对于链表,如A-B-C形态,只能一级一级去找
 *
 * 插入节点
 * 1.尾插
 * □-□-□-□-□-□-□-null
 * 将尾节点的next指针,由指向null,变为指向新的结点
 * 2.头插
 * □-□-□-□-□-□-□-null
 * 把要插入的节点的next指针指向原链表的头结点
 * 把新节点 变为链表的头结点
 * 3.中间插入
 * 如在A-B之间插入,把前一个节点A的next指针指向新节点,把新节点的next指针指向B
 * 即完成中间插入
 *
 * 只要内存空间允许,能够插入链表的元素的是无穷无尽的,不需要考虑扩容的问题
 *
 * 单链表的删除
 * 1.删除头结点
 * 直接删除即可,再把原头结点指向的结点变为新的头结点
 *
 * 2.删除中间
 * □-□-□-A-B-C-□-null
 * 此时删除B,需要将A的next指针指向C
 * 3.删除尾节点
 * □-□-□-A-B-C-null
 * 删除尾节点C,将B的next指针指向NULl
 *
 *
 *
 * 本class为单链表的节点
 * (NODE)
 * @author zhaoxu
 * @className Node
 * @projectName JavaConcentration
 * @date 2020/9/15 9:26
 */
public class SingleLinkedListNode {
    /**
     * 存放数据的 data
     * @author zhaoxu
     */
    public int data;

    /**
     * 指向下一个节点的指针next(对象引用)
     * 例子
     * Apple  apple = new Apple();
     * 此时apple为对象实例在栈中的地址(对象引用)
     * 对象实际在堆中
     * 如此声明,则是拿到下一个节点的引用
     * @author zhaoxu
     */
    public SingleLinkedListNode next;


    public SingleLinkedListNode(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SingleLinkedListNode getNext() {
        return next;
    }

    public void setNext(SingleLinkedListNode next) {
        this.next = next;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SingleLinkedListNode that = (SingleLinkedListNode) o;
        return data == that.data &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    @Override
    public String toString() {
        return "SingleLinkedListNode{" +
                "data=" + data +
                '}';
    }
}
