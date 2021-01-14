package com.practice.DataStructureAndAlgorithm.ProcessArray;

import com.practice.DataStructureAndAlgorithm.processLinkedList.JavaLinkedList;
import com.practice.DataStructureAndAlgorithm.processLinkedList.SingleLinkedListNode;

/**
 * @author zhaoxu
 * @className ArrayToLinkedList
 * @projectName JavaConcentration
 * @date 2021/1/14 13:42
 */
public class ArrayToLinkedList {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {3, 2, 32, 1, 3, 213};
    ListNode head = arrayToLinkedList(arr);
    //遍历链表
    ListNode temp = head;
    for (int i = 0; i <arr.length; i++) {
      System.out.println(temp.val);
      temp= temp.next;
    }
  }

  public static ListNode arrayToLinkedList(int[] arr) {
    ListNode head;
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("数组为NULL或没有元素,无法转换");
    } else {
      head = new ListNode(arr[0]);
      ListNode temp = head;
      for (int i = 1; i < arr.length; i++) {
        temp.next = new ListNode(arr[i]);
        temp = temp.next;
      }
    }
    return head;
  }
}
