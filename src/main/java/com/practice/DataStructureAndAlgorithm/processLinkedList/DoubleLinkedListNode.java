package com.practice.DataStructureAndAlgorithm.processLinkedList;

/**
 * 想让每个节点都能回溯到它的前置节点 我们可以使用双向链表
 *
 * 双向链表比单向链表稍微复杂一些,它的每一个节点除了拥有data 和 next指针
 * 还拥有指向前置节点的 prev指针
 *
 * 所以双向链表的头结点的prev指向null
 * 尾节点的next指向null
 *
 * 对于数组,在内存中存储方式,分配固定的,连续完整空间,进行顺序储存
 * 链表在内存中存储方式则是随机储存,在内存中见缝插针,每一个节点分布在内存中不同的位置
 * 依靠next指针关联,如此可以灵活有效的利用零散的碎片空间
 *
 *
 *
 * @author zhaoxu
 * @className DoubleLinkedListNode
 * @projectName JavaConcentration
 * @date 2020/9/15 9:34
 */
public class DoubleLinkedListNode {

    int data;
    DoubleLinkedListNode prev;
    DoubleLinkedListNode next;
}
