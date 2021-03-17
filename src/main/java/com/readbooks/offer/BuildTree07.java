package com.readbooks.offer;

import com.practice.DataStructureAndAlgorithm.leetcode.structure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据二叉树的遍历结果求二叉树的性质1 1. 在前序遍历的第一个数字为root 2. 在二叉树数字不重复的情况下,将root带入中序遍历序列 ,可得左子树和右子树的内容
 *
 * <p>如 前序遍历 preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7]
 * 你可以假设树中没有重复的元素。
 * 那么得到
 * root 3
 * root 左子树元素 9
 * root 右子树元素 15 20 7
 *  对于任意一棵树而言
 *  前序遍历:根节点-左子树的前序遍历,右子树的前序遍历
 *  并无限在子树中递归
 *
 *  中序遍历相仿
 *  [左] [中] [右]
 *
 *
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


    /**
     * 时间复杂度O(n^2)
     * 可以使用map引入空间复杂度 降低时间复杂度
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
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
            // 左开右闭的!!!!!!!!!!!!
            int[] leftChildPreorder = Arrays.copyOfRange(preorder,1,rootIndexInInorder+1);
            int[] leftChildInorder = Arrays.copyOfRange(inorder,0,rootIndexInInorder);


            int[] rightChildPreorder = Arrays.copyOfRange(preorder,rootIndexInInorder+1,preorder.length);
            int[] rightChildInorder = Arrays.copyOfRange(inorder,rootIndexInInorder+1,inorder.length);



            TreeNode leftChild  = buildTree(leftChildPreorder,leftChildInorder);
            TreeNode rightChild  = buildTree(rightChildPreorder,rightChildInorder);

            TreeNode treeNode = new TreeNode(rootIntVal,leftChild,rightChild);
            return treeNode;
        }else {
            return null;
        }

    }



    /**
     * 官方题解
     * 引入map降低复杂度
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }



}
