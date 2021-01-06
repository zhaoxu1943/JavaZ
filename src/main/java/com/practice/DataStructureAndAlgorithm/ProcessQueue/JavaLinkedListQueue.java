package com.practice.DataStructureAndAlgorithm.ProcessQueue;

import com.practice.DataStructureAndAlgorithm.processLinkedList.JavaLinkedList;

/**
 * 队列的链表实现 □-□-□-□-□-□-□-□-□-□-NULL 队尾 队头指向NULL
 *
 * @author zhaoxu
 * @className JavaLinkedListQueue
 * @projectName JavaConcentration
 * @date 2020/9/25 12:06
 */
public class JavaLinkedListQueue implements JavaQueue {

  /**
   * 内部的链表存储
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private JavaLinkedList linkedList;

  /**
   * 队列元素
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private int size;

  public JavaLinkedListQueue() {
    linkedList = new JavaLinkedList();
    // 初始化size为0
    size = 0;
  }

  /**
   * 队列的基本操作 入队
   *
   * @param element
   * @return
   * @throws
   * @author zhaoxu
   */
  @Override
  public void enQueue(int element) {
    // 认为链表容量无限,且队列的链表实现
    linkedList.insert(size, element);
    size++;
  }

  /**
   * 出队
   *
   * @return
   * @throws
   * @author zhaoxu
   */
  @Override
  public int deQueue() {
    if (size <= 0) {
      throw new IllegalStateException("数组容量为空,size=" + size + ",无法进行出队操作");
    }
    return linkedList.deleteNode(0).getData();
  }

  /**
   * 打印队列
   *
   * @return
   * @throws
   * @author zhaoxu
   */
  @Override
  public void printQueue() {
    linkedList.print();
  }

  /**
   * 链表队列的单元测试
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public static void main(String[] args) {
    JavaLinkedListQueue queue = new JavaLinkedListQueue();
    System.out.println("---------进行队列入队测试------------");
    queue.enQueue(1);
    queue.enQueue(321);
    queue.enQueue(33219);
    queue.printQueue();
    System.out.println("---------进行队列出队测试------------");
    System.out.println("---------出队一次------------");
    System.out.println("出队元素:"+queue.deQueue());
    queue.printQueue();
    System.out.println("---------出队二次------------");
    System.out.println("出队元素:"+queue.deQueue());
    queue.printQueue();
    System.out.println("---------出队三次------------");
    System.out.println("出队元素:"+queue.deQueue());
    queue.printQueue();
    System.out.println("---------进行队列出队越界测试------------");
    queue.deQueue();
    queue.printQueue();
  }
}
