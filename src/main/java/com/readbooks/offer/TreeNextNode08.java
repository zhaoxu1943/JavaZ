package com.readbooks.offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 二叉树的下一个节点
 *
 * <p>给定一颗二叉树和其中的一个节点 如何找出中序遍历序列的下一个节点? 树中的节点除了有两个分别指向左孩子,右孩子的指针 还有一个指向父节点的指针
 *
 * @author zhaoxu
 * @className TreeNextNode08
 * @projectName JavaConcentration
 * @date 2021/3/18 9:13
 */
public class TreeNextNode08 {

  private static class SpecialTreeNode {

    public SpecialTreeNode fatherNode;
    public SpecialTreeNode leftChildNode;
    public SpecialTreeNode rightChildNode;
    public char val;

    public SpecialTreeNode(char val) {
      this.val = val;
    }

    public SpecialTreeNode(SpecialTreeNode fatherNode, SpecialTreeNode leftChildNode, SpecialTreeNode rightChildNode, char val) {
      this.fatherNode = fatherNode;
      this.leftChildNode = leftChildNode;
      this.rightChildNode = rightChildNode;
      this.val = val;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SpecialTreeNode that = (SpecialTreeNode) o;
      return val == that.val &&
              Objects.equals(fatherNode, that.fatherNode) &&
              Objects.equals(leftChildNode, that.leftChildNode) &&
              Objects.equals(rightChildNode, that.rightChildNode);
    }

    @Override
    public int hashCode() {
      return Objects.hash(fatherNode, leftChildNode, rightChildNode, val);
    }
  }



  public static void main(String[] args) {

    // 给一颗二叉树
    // 根节点
    SpecialTreeNode root_a = new SpecialTreeNode('a');

    SpecialTreeNode b = new SpecialTreeNode('b');

    SpecialTreeNode c = new SpecialTreeNode('c');

    SpecialTreeNode d = new SpecialTreeNode('d');

    SpecialTreeNode e = new SpecialTreeNode('e');

    SpecialTreeNode f = new SpecialTreeNode('f');

    SpecialTreeNode g = new SpecialTreeNode('g');

    SpecialTreeNode h = new SpecialTreeNode('h');

    SpecialTreeNode i = new SpecialTreeNode('i');

    // 一层四指针
    root_a.leftChildNode = b;
    root_a.rightChildNode = c;
    b.fatherNode = root_a;
    c.fatherNode = root_a;

    // 二层8指针
    b.leftChildNode = d;
    b.rightChildNode = e;
    c.leftChildNode = f;
    c.rightChildNode = g;
    d.fatherNode = b;
    e.fatherNode = b;
    f.fatherNode = c;
    g.fatherNode = c;

    //三层4指针
    e.leftChildNode=h;
    e.rightChildNode=i;
    h.fatherNode=e;
    i.fatherNode=e;

    TreeNextNode08 treeNextNode08 = new TreeNextNode08();
    SpecialTreeNode expectNode =treeNextNode08.findNextNode(root_a,g);
    System.out.println("");
    System.out.println(expectNode.val);
  }

  /**
   * 给一棵二叉树(根节点)
   * 任意一个节点 node
   * 寻找下一个中序遍历节点
   * 如给root和 b
   * 中序
   * [d b h e i a f c g]
   * 那么输出h
   *
   * 时间复杂度 N^2
   * 空间复杂度N
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */

  private  List<SpecialTreeNode> nodeLinkedList = new LinkedList<>();

  public SpecialTreeNode findNextNode(SpecialTreeNode root,SpecialTreeNode node) {
    //进行中序递归遍历,拿到链表
    inorder(root);
    nodeLinkedList.forEach(n -> System.out.print(n.val));
    //对链表进行遍历
    int nodeIndex =  nodeLinkedList.indexOf(node);
    int expectNodeIndex = nodeIndex+1;
    if (expectNodeIndex< nodeLinkedList.size()){
      return nodeLinkedList.get(expectNodeIndex);
    }else{
      throw new IllegalArgumentException("中序最后节点无后续!");
    }
  }

  /**
   * 中序递归遍历二叉树
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private void inorder(SpecialTreeNode root){
    if (root!=null){
      inorder(root.leftChildNode);
      nodeLinkedList.add(root);
      inorder(root.rightChildNode);
    }
  }







}
