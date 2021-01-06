package com.practice.DataStructureAndAlgorithm.processTree;

/**
 * 二叉树的数组存储
 * 使用数组存储时
 * 会按照层级顺序,并从左到右放到数组的对应的位置上
 * 如果某一个节点的左孩子或者右孩子空缺
 * 则数组相应的位置也空出来
 *
 * 通俗点说 就是任何一个二叉树的数组存储 都要占用一个满二叉树的空间
 *
 * 数组存储的下标规律
 * 1.一个父节点的下标是indexParent
 * 左孩子下标是 left = 2 x indexParent +1
 * right = 2 x indexParent +2
 * 证明思路 每行下标规律
 * 第k行m个下标为 2^(k-1)+m
 * 对于一个稀疏二叉树来说,数组存储比较浪费空间
 *
 * 二叉堆适合使用数组存储
 * @author zhaoxu
 * @className ZBinaryTreeArray
 * @projectName JavaConcentration
 * @date 2020/10/23 23:55
 */
public class ZBinaryTreeArray implements  ZBinaryTree{


}
