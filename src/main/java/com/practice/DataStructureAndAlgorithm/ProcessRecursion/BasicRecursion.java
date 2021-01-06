package com.practice.DataStructureAndAlgorithm.ProcessRecursion;

/**
 * 基础递归,明确基线条件与递归条件
 * @author zhaoxu
 * @className BasicRecursion
 * @projectName JavaConcentration
 * @date 2020/10/26 22:26
 */
public class BasicRecursion {







    public static void main(String[] args) {
         int i = 66;
        //无限递归
      //  recursionCountDownUnlimited(i);

        //有限递归
        recursionCountDown(i);
    }

    /**
     * 不设置基线条件,导致无限递归
     * 进而导致 java.lang.StackOverflowError
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static void recursionCountDownUnlimited(int i) {
        System.out.println(i);
        recursionCountDownUnlimited(i-1);
    }



    /**
     * 设置基线条件,导致无限递归
     * 进而导致 java.lang.StackOverflowError
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static void recursionCountDown(int i) {
        System.out.println(i);
        if (i<=0){  //------------------基线条件(终止条件)
          System.exit(-1);
        }else { //------------------递归条件
            recursionCountDown(i-1);
        }
    }
}
