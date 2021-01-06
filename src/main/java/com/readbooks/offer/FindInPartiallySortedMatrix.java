package com.readbooks.offer;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 二维数组(矩阵)中的查找
 *
 * 在一个二维数组中
 * 每一行都从左到右递增
 * 每一列都从上到下递增
 * 输入这样一个二维数组 和一个整数
 * 判断数组中是否有这个整数
 * @author zhaoxu
 * @className FindInPartiallySortedMatrix
 * @projectName JavaConcentration
 * @date 2020/12/23 12:34
 */
public class FindInPartiallySortedMatrix {


    /**
     * 测试方法
     * 1.java中二维数组的表示
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
  public static void main(String[] args) {
    int[][]  intSortedMatrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
    //printSortedMatrix(intSortedMatrix);
    System.out.println(containsFromLeftBehindCorner(intSortedMatrix,5));
  }


  /**
   * 逐行打印矩阵
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public static void  printSortedMatrix(int[][] matrix) {
      for (int[] row :matrix ) {
          for (int i : row ) {
            System.out.println(i);
          }
      }
  }

    /**
     * 矩阵转化为ArrayList
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static HashSet<Integer>  matrixToHashSet(int[][] matrix) {
        HashSet<Integer> matrixSet = new HashSet<>();
        for (int[] row :matrix ) {
            for (int i : row ) {
                matrixSet.add(i);
            }
        }
        return matrixSet;
    }


    /**
     * 输入二维数组和矩阵,是够包含
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static boolean contains(int[][] matrix,int target) {
        HashSet<Integer> matrixSet = new HashSet<>();
        for (int[] row :matrix ) {
            for (int i : row ) {
                matrixSet.add(i);
            }
        }
        return matrixSet.contains(target);
    }




    /**
     * 二维矩阵查找
     * 利用有序的条件
     * 如果任选一个点开始 将面临分支选择的问题
     * 而应使用右上角 或者左下角开始的情况
     * 此时一个大一个小
     * 滋滋直接走过去
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static boolean containsFromCorner(int[][] matrix,int target) {
        //数组不为null
        //行数不为0
        //列数不为0
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //java 中二维数组的行等于 二维数组的length
        int rows = matrix.length;
        //二位数组的列数 等于任一行的元素数,这里取第一行
        int columns = matrix[0].length;

        //定义起始点 0行 最后一列 ,即右上角
        int row = 0, column = columns - 1;

        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

  /**
   * 二维矩阵查找 利用有序的条件 如果任选一个点开始 将面临分支选择的问题 而应使用右上角 或者左下角开始的情况 此时一个大一个小 滋滋直接走过去 我整一个左下角
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public static boolean containsFromLeftBehindCorner(int[][] matrix, int target) {
    // 我整一个左下角开始
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    } else {
      int row = matrix.length;
      int column = matrix[0].length;
      // 起始点左下角
      int startPointRow = row - 1;
      int startPointColumn = 0;
      while (startPointRow >= 0 && startPointColumn < column) {
        int point = matrix[startPointRow][startPointColumn];
        if (point == target) {
          return true;
        } else if (point > target) {
          startPointRow = startPointRow - 1;
        } else {
          startPointColumn = startPointColumn + 1;
        }
      }
    }
    return false;
  }
}
