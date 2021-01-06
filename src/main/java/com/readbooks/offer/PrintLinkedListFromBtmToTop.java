package com.readbooks.offer;

import com.practice.DataStructureAndAlgorithm.processLinkedList.JavaLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 从尾到头打印链表
 *
 * @author zhaoxu
 * @className PrintLinkedListFromBtmToTop
 * @projectName JavaConcentration
 * @date 2021/1/4 19:11
 */
public class PrintLinkedListFromBtmToTop {

  public static void main(String[] args) {
      JavaLinkedList javaLinkedList = new JavaLinkedList();
      javaLinkedList.insert(0,3);
      javaLinkedList.insert(1,1);
      javaLinkedList.insert(2,3321);
      javaLinkedList.insert(3,32781);
      javaLinkedList.insert(4,5);
      javaLinkedList.print();

      System.out.println("------------");
      javaLinkedList.insert(1,52);
      javaLinkedList.print();
      System.out.println("------------");

      javaLinkedList.printReserve();
  }




}

