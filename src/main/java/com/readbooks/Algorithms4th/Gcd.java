package com.readbooks.Algorithms4th;


import io.swagger.models.auth.In;

/**
 *
 * 欧几里得算法
 * 寻找两个数的最大公约数
 *
 * 计算两个非负整数p和q的最大公约数
 * 若q是0 则最大公约数为p(递归终止条件)
 * 否则
 * 将p除以q得到余数r
 * p与q的最大公约数即q与r的最大公约数(递归条件)
 * @author zhaoxu
 * @className Gcd
 * @projectName JavaConcentration
 * @date 2021/2/8 9:43
 */
public class Gcd {

  public static void main(String[] args) {
     
    int p = 11;
    int q = 55;
    Gcd gcd = new Gcd();
    System.out.println(gcd.gcd(p,q));
  }



  private int gcd(int p,int q) {
      if (q==0){
          return p;
      }else{
          int r =  p%q;
          return gcd(q,r);
      }
  }
}
