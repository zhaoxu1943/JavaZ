package com.readbooks.offer;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 树的逻辑
 *
 * <p>除根节点以外 每个节点只有一个父节点 根节点没有父节点
 *
 * <p>除叶子节点以外 所有节点都有一个或多个子节点
 *
 * <p>叶子节点:没有子节点
 *
 * <p>父节点和子节点之间用指针连接
 *
 * <p>树的操作会涉及到大量的指针
 *
 * <p>面试时的树 大部分是二叉树:二叉树是树的一种特殊结构 在二叉树中每个节点最多只能有两个子节点
 *
 * <p>而二叉树最重要的操作就是遍历,即按照某一顺序访问树中的所有节点,包含前序,中序,后序遍历
 *
 * <p>前序:根在前,根-左-右
 *
 * <p>中序:根在中,左-根-右
 *
 * <p>后序:根在后,左-右-根
 *
 * <p>3 中遍历都有递归和循环的写法
 *
 * <p>每种遍历的递归实现都要比循环简洁一些,故应对这3*2中写法了如指掌
 *
 * 从更宏观来看,分为深度优先遍历(前序,中序,后序)
 *
 * 广度优先遍历(层序遍历)
 *
 * 二叉树用递归的方式进行前序,中序,后序的遍历,是最为自然的方式,代码非常简单
 * 三种遍历方式的区别 仅仅是输出位置的不同
 *
 * 前序遍历输出在前
 * 中序遍历输出在中间
 * 后序遍历输出在后
 *
 * @author zhaoxu
 * @className Tree
 * @projectName JavaConcentration
 * @date 2021/1/25 8:36
 */
public class Tree {

  /**
   * TreeNode节点
   * 包含左孩子,右孩子和自身value值
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  static class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      this.value = x;
    }
  }


  /**
   * 构建二叉树
   * 输入为链表
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode  treeNode = null;
        if (inputList==null ||inputList.isEmpty()){
         return null;
        }
        //利用链表的性质,Removes and returns the first element from this list.
        //移除且返回链表的第一个元素
        Integer data = inputList.removeFirst();
        if (data!=null){
          treeNode = new TreeNode(data);
          treeNode.left = createBinaryTree(inputList);
          treeNode.right = createBinaryTree(inputList);
        }
        return treeNode;

  }







  /**
   * 测试方法
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public static void main(String[] args) {

    //二叉树的构建,返回根节点
//    LinkedList<Integer> linkedList = new LinkedList<>();
//    linkedList.add(1);
//    linkedList.add(2);
//    linkedList.add(3);
//    linkedList.add(4);
//    linkedList.add(154);
//    linkedList.add(13);
//    linkedList.add(132);
//    linkedList.add(11);
//
//    TreeNode root = createBinaryTree(linkedList);


    //写一颗二叉树,剑指offer page61
    //根节点
    TreeNode root = new TreeNode(10);

    root.left = new TreeNode(6);
    root.right= new TreeNode(14);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(8);

    root.right.left = new TreeNode(12);
    root.right.right = new TreeNode(16);

    //前序递归
    Tree tree = new Tree();
    System.out.println("---前序");
    tree.preOrderRecursion(root);
    System.out.println("---中序");
    tree.inOrderRecursion(root);
    System.out.println("---后序");
    tree.postOrderRecursion(root);
  }



  /**
   * 前序-递归
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public void preOrderRecursion(TreeNode root) {
        if (root == null) {
          return;
        }else{
            System.out.println(root.value);
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }

  }


  /**
   * 前序-循环-使用栈的循环遍历
   * 为何使用栈?
   * 绝大多数都可以使用栈来解决
   * 那么二叉树的遍历使用基于栈的循环来解决
   * 重点是回溯
   * 通过栈顶出栈操作进行回溯
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public ArrayList<Integer> firstOrderCycle(TreeNode root) {
    while (root!=null) {

    }



    return Lists.newArrayList();
  }





  /**
   * 中序-递归
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public void inOrderRecursion(TreeNode root) {
    if (root==null){
      return;
    }else{
      inOrderRecursion(root.left);
      System.out.println(root.value);
      inOrderRecursion(root.right);
    }
  }


  /**
   * 中序-循环
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public ArrayList<Integer> midOrderCycle(TreeNode root) {
    return Lists.newArrayList();
  }


  /**
   * 后序-递归
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public void postOrderRecursion(TreeNode root) {
    if (root==null){
        return;
    }else{
      postOrderRecursion(root.left);
      postOrderRecursion(root.right);
      System.out.println(root.value);
    }
  }


  /**
   * 后序-循环
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public ArrayList<Integer> lastOrderCycle(TreeNode root) {
    return Lists.newArrayList();
  }






}
