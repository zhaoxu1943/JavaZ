package com.test.toutiao;

/**
 * 求数组中每两个值异或的最大值
 *
 * <p>首先弄清异或 异或，英文为exclusive OR，缩写成xor
 *
 * <p>异或（eor）是一个数学运算符。它应用于逻辑运算。异或的数学符号为“⊕”，计算机符号为“eor”。其运算法则为：
 *
 * <p>a⊕b = (¬a ∧ b) ∨ (a ∧¬b) 如果a、b两个值不相同，则异或结果为1。
 * 如果a、b两个值相同，异或结果为0。
 *  异或也叫半加运算，其运算法则相当于不带进位的二进制加法：
 *  二进制下用1表示真，0表示假，
 *  则异或的运算法则为：
 *  0⊕0=0，
 *  1⊕0=1，
 *  0⊕1=1，
 *  1⊕1=0
 *  （同为0，异为1），
 *
 *  这些法则与加法是相同的，只是不带进位，所以异或常被认作不进位加法。
 *
 *  异或异或,即为求异
 *  在java中异或就是不进位的加法
 *  转为二进制后逐位计算
 *
 * @author zhaoxu
 * @className XOR
 * @projectName JavaConcentration
 * @date 2021/2/7 13:53
 */
public class XOR {

  public static void main(String[] args) {
    //java中的异或
      if (true^true){
      System.out.println(1);
      }
    if (true^false){
      System.out.println("异");
    }



    int[] arr =  new int[]{12,2,32,32,22,21,23,12,3,12,3,1};


  }



//  /**
//   * n的复杂度寻找最大异或
//   *
//   * @author zhaoxu
//   * @param
//   * @return
//   * @throws
//   */
//  private int  findMaxXor(int[] arr) {
//
//  }

    /**
     * xor性质探究
     * a b为整数
     *
     * 当有
     * a^b=c
     * 则有
     * c^a=b
     * c^b=a
     * 通过二进制不进位加法性质可整得
     *
     *
     *
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private void xor(){
        System.out.println(567^432);

        Integer i = 567;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toHexString(i));

        Integer i2 = 432;
        System.out.println(Integer.toBinaryString(i2));
        System.out.println(Integer.toHexString(i2));

        int i3 = i^i2;
        System.out.println(i3);
        System.out.println(Integer.toBinaryString(i3));
        System.out.println(Integer.toHexString(i3));
    }
}
