package com.readbooks.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 反转打印链表
 * @author zhaoxu
 * @className ReversePrint
 * @projectName JavaConcentration
 * @date 2021/1/19 8:46
 */
public class ReversePrint {


    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    //

      ListNode head = new ListNode(1);
      head.next = new ListNode(3);
      head.next.next = new ListNode(2);

      int[] a= reversePrint2(head);
    System.out.println(1);
  }

    /**
     * 栈容器
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        //临时节点
        ListNode tempNode = head;

        while(tempNode!=null){
            stack.add(tempNode.val);
            tempNode = tempNode.next;
        }
        int size = stack.size();
        //使用栈时编程注意点 pop会使栈size变小 导致循环错误
        //这里遍历后 采用一个固定值存放
        int[] reversePrintArr = new int[size];
        for(int i = 0;i<size;i++){
            reversePrintArr[i] = stack.pop();
        }
        return  reversePrintArr;
    }

    /**
     * 递归
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static  ArrayList<Integer> tmp = new ArrayList<>();

    public static int[] reversePrint2(ListNode head) {
        //除了使用栈容器
        //递归本质上是一个栈
        //使用递归来做
        //基线条件:只有一个元素时反转为其自身
        //递归条件:逐渐缩小为一个元素,也就是访问下一个元素
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

        /**
         * 保持引用 重复调用
         * @author zhaoxu
         * @param
         * @return
         * @throws
         */
    public static void  recur(ListNode head) {
        if(head == null) {
            return;
        }
        recur(head.next);
        tmp.add(head.val);


    }



}
