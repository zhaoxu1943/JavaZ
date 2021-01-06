package com.practice.DataStructureAndAlgorithm.ProcessRecursion;

/**
 * 阶乘计算
 * @author zhaoxu
 * @className Factorial
 * @projectName JavaConcentration
 * @date 2020/10/26 22:47
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(7));

        System.out.println(factorialRecursion(7));
    }

    /**
     * 阶乘计算
     * 循环写法
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int factorial(int i) {
        int s =1;
        if (i<1) {
            throw new IllegalArgumentException("参数不能为1以下的正整数!");
        }else{
            for (int j = i; j >0 ; j--) {
              s=j*s;
            }
        }return s;
    }



    /**
     * 阶乘计算
     * 递归写法
     * 终止条件 i = 1
     * 循环条件i>1
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int factorialRecursion(int i) {

        if (i<1) {
            throw new IllegalArgumentException("参数不能为1以下的正整数!");
        }else {
            if (i==1){ //基线条件
                return i;
            }else{ //递归条件
               return i*factorialRecursion(i-1);
            }

        }

    }
}
