package com.practice.DataStructureAndAlgorithm.processLinkedList;

import java.util.Collections;

/**
 * 单链表实现
 *
 * @author zhaoxu
 * @className JavaLinkedList
 * @projectName JavaConcentration
 * @date 2020/9/15 12:17
 */
public class JavaLinkedList {

  // 头结点指针
  private SingleLinkedListNode head;
  // 尾节点指针
  private SingleLinkedListNode last;
  // 链表实际长度
  private int size;

  /**
   * 构造方法,创建链表
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public JavaLinkedList() {
  }

  /**
   * 插入元素
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public void insert(int index,int data) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("超出链表结点范围!");
    } else {
      // 声明一个即将插入的链表结点
      //由于声明了头尾,所以头尾都要处理
      SingleLinkedListNode insertedNode = new SingleLinkedListNode(data);
      if (size == 0) {
        // 空链表
        head = insertedNode;
        last = insertedNode;
      } else if (index == 0) {
        // 即非空链表,头插的情况
        // 头插两步走, 新头指向旧头,head指向新头结点
        insertedNode.next = head;
        head = insertedNode;
      } else if (size == index) {
        // 如size == 6 ,此时index为0-5,此时插入则为尾插
        // 尾插两部走
        last.next = insertedNode;
        last = insertedNode;
      } else {
        // 最后一种,非空链表的中间插入,两步走
        SingleLinkedListNode prevNode = get(index-1);
        insertedNode.next = prevNode.next;
        prevNode.next = insertedNode;
      }
      size++;
    }
  }

  /**
   * 链表查找元素
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public SingleLinkedListNode get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("链表下标越界!");
    }
    // 拿到头结点的复制,通过头结点next 一个个去找
    SingleLinkedListNode result = head;
    for (int i = 0; i < index; i++) {
      //链表自增 本身next 别瞎写
      result = result.next;
    }
    return result;
  }

  /**
   * 链表元素的删除 依然分为 头 中 尾,线性表的常用思考形式
   *
   * @author zhaoxu
   * @param
   * @return SingleLinkedListNode 删除的链表元素
   * @throws
   */
    public SingleLinkedListNode deleteNode(int index) {
      SingleLinkedListNode result = null;
      if (size ==0) {
        throw new IllegalStateException("链表元素为空,无法进行删除!");
      }else if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("下标越界");
        } else {
        //此时链表存在元素,且index不越界,进行判断删除

        // 将要删除的元素
        result = get(index);
        if (index == 0) {
          // 删除头
          head = head.next;
        }else if (index == size-1) {
          //删除尾
          //得到尾节点的前一个节点
          SingleLinkedListNode prevNode = get(index-1);
          prevNode.next= null;
          last= prevNode;
        }else {
          //中间删除
        SingleLinkedListNode prevNode = get(index-1);
        prevNode.next=get(index).next;
        }
        size--;
      }
      return result;
    }




    /**
     * 修改链表元素
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public void updateNode(int value,int index) {
      if (size ==0) {
        throw new IllegalStateException("链表元素为空,无法进行update!");
      }else if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("下标越界");
      }else {
        //进行元素的update
        SingleLinkedListNode origin = get(index);
        origin.data = value;
      }
   }




   /**
    * 链表元素的打印
    * @author zhaoxu
    * @param
    * @return
    * @throws
    */
    public void print() {
    if (size == 0) {
      throw new IllegalStateException("链表元素为空,无法进行打印!");
    }else {
      //链表不为空,开始打印
      // 制作头结点的复制,并打印头结点
      SingleLinkedListNode temp = head;
      if (temp!=null) {
        for (int i = 0; i < size; i++) {
          System.out.println(temp.data);
          temp = temp.next;
        }
      }
    }
    }



  /**
   * 链表元素的反向打印
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public void printReserve() {
    if (size == 0) {
      throw new IllegalStateException("链表元素为空,无法进行打印!");
    }else {
      //链表不为空,开始打印
      // 制作头结点的复制,并打印头结点
      SingleLinkedListNode temp = head;
      int[] dataReserve = new int[size];

      if (temp!=null) {
        for (int i = 0; i < size; i++) {
          dataReserve[size-i-1] = temp.data;
          temp = temp.next;
        }
      }
      for (int i  :dataReserve ) {
        System.out.println(i);
      }
    }
  }


  public static void main(String[] args) {
      JavaLinkedList javaLinkedList = new JavaLinkedList();
      //测试插入
    System.out.println("测试插入");
      javaLinkedList.insert(0,432);
      javaLinkedList.insert(1,321);
      javaLinkedList.insert(2,223);
      javaLinkedList.print();
      System.out.println(javaLinkedList.head.toString());
    // 测试查询
    System.out.println("测试查询");
    System.out.println(javaLinkedList.get(0));
    System.out.println(javaLinkedList.get(1));
    System.out.println(javaLinkedList.get(2));
   //越界测试
    // System.out.println( javaLinkedList.get(3));


    // 测试删除
    System.out.println("测试删除");
    System.out.println(javaLinkedList.deleteNode(2));
    javaLinkedList.print();


    //测试更新
    System.out.println("测试更新");
    javaLinkedList.updateNode(3123123,1);
    javaLinkedList.print();


  }

  public SingleLinkedListNode getHead() {
    return head;
  }

  public void setHead(SingleLinkedListNode head) {
    this.head = head;
  }

  public SingleLinkedListNode getLast() {
    return last;
  }

  public void setLast(SingleLinkedListNode last) {
    this.last = last;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
