package com.practice.DataStructureAndAlgorithm.leetcode.structure;

/**
 * @author zhaoxu
 * @className TreeNode
 * @projectName JavaConcentration
 * @date 2021/3/17 9:25
 */
public class TreeNode {
      public int value;
      public TreeNode left;
      public TreeNode right;


      public TreeNode() {

      }

     public TreeNode(int value) {
          this.value = value;
      }

     public TreeNode(int value, TreeNode left, TreeNode right) {
         this.value = value;
         this.left = left;
         this.right = right;
      }
}

