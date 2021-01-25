package com.practice.DataStructureAndAlgorithm.leetcode;

/**
 * 力扣7 整数翻转 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * <p>如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 *
 * <p>假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * <p>示例 1：
 *
 * <p>输入：x = 123 输出：321 示例 2：
 *
 * <p>输入：x = -123 输出：-321 示例 3：
 *
 * <p>输入：x = 120 输出：21 示例 4：
 *
 * <p>输入：x = 0 输出：0
 *
 * <p>提示：
 *
 * <p>-231 <= x <= 231 - 1
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaoxu
 * @className ReverseInt_7
 * @projectName JavaConcentration
 * @date 2021/1/25 13:23
 */
public class ReverseInt_7 {

  public static void main(String[] args) {
    int i1 = -13232;
    System.out.println(reverse(i1));

      int i2 = 31213232;
      System.out.println(reverse(i2));
  }

    /**
     * 转成字符串没有一颗算法的心!
     * 玩笑脸
     * 这是官方题解,品一下拓展下思路
     *
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }


}
