package com.practice.DataStructureAndAlgorithm;

/**
 * 输出从1到100 如果3的倍数,替换为Fizz,5的倍数替换为Buzz
 * 能被3,5同时整除 打印FizzBuzz
 * @author zhaoxu
 * @className FizzBuzz
 * @projectName JavaConcentration
 * @date 2020/7/6 22:50
 */
public class FizzBuzz {

    public static void main(String[] args) {
        for (int i = 1; i <= 100 ; i++) {
            if ((i%3==0)&&(i%5==0)){
                System.out.println("FizzBuzz");
            }else if (i%3==0) {
                System.out.println("Fizz");
            }else if (i%5==0){
                System.out.println("Buzz");
            }else {
                System.out.println(" " +i);
            }

        }



    }
}
