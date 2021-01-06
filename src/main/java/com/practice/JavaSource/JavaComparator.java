package com.practice.JavaSource;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName JavaComparator
 * @Description Comparator中重写compare的解读
 * @Author zhaoxu
 * @Date 2019/11/21 20:56
 * @Version 1.0
 **/
public class JavaComparator {

    //@param o1 the first object to be compared.
    //     * @param o2 the second object to be compared.
    //     * @return a negative integer, zero, or a positive integer as the
    //     *         first argument is less than, equal to, or greater than the
    //     *         second.

   // int compare(T o1, T o2);

    //简单来说 重写Comparator比较器中的compare方法
    // 如果return负数就是o1比o2小
    //0 相等
    //return正数则是o1比o2大

    public static void main(String[] args) {
        Integer[] a = {1,4,5,1,2,5,1};
        //所以最简单从小到大的写法是
        Arrays.sort(a, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                }
        );
        //比较器：负数第一个参数放前面，正数第二个参数放前面，相等则二者是相等的
        Arrays.sort(a, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                        //是正常写的逆序
                    }
                }
        );
    }
}
