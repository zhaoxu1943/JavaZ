package com.readbooks.offer;

import com.practice.DataStructureAndAlgorithm.leetcode.structure.TreeNode;

import java.util.Arrays;

/**
 * 根据二叉树的遍历结果求二叉树的性质1 1. 在前序遍历的第一个数字为root 2. 在二叉树数字不重复的情况下,将root带入中序遍历序列 ,可得左子树和右子树的内容
 *
 * <p>如 前序遍历 preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7]
 * 你可以假设树中没有重复的元素。
 * 那么得到
 * root 3
 * root 左子树元素 9
 * root 右子树元素 15 20 7
 *
 *
 *
 * @author zhaoxu
 * @className BuildTree07
 * @projectName JavaConcentration
 * @date 2021/3/17 9:14
 */
public class BuildTree07 {

  public static void main(String[] args) {
    //
      int[] preorder =  new int[]{3,9,20,15,7};
      int[] inorder = new int[]{9,3,15,20,7};

      BuildTree07 buildTree07 = new BuildTree07();
      TreeNode treeNode = buildTree07.buildTree(preorder,inorder);

      Tree.preOrderRecursion(treeNode);
      Tree.inOrderRecursion(treeNode);

  }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //根节点的值

        if (preorder.length!=0){
            int rootIntVal = preorder[0];

            // 根节点带入右子树,得到根节点值的index
            int rootIndexInInorder = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i]==rootIntVal){
                    rootIndexInInorder = i;
                    break;
                }
            }
            //之后进行数组的拷贝,拿到递归的参数
            int[] leftChildPreorder = Arrays.copyOfRange(preorder,1,rootIndexInInorder);
            int[] leftChildInorder = Arrays.copyOfRange(inorder,0,rootIndexInInorder-1);
            int[] rightChildPreorder = Arrays.copyOfRange(preorder,rootIndexInInorder+1,preorder.length-1);
            int[] rightChildInorder = Arrays.copyOfRange(inorder,rootIndexInInorder+1,inorder.length-1);
            TreeNode leftChild  = buildTree(leftChildPreorder,leftChildInorder);
            TreeNode rightChild  = buildTree(rightChildPreorder,rightChildInorder);
            TreeNode treeNode = new TreeNode(rootIntVal,leftChild,rightChild);
            return treeNode;
        }else {
            return null;
        }

    }



}
