package com.practice.JavaException;

/**
 * @author zhaoxu
 * @className JavaNPE
 * @projectName JavaConcentration
 * @date 2020/7/28 14:04
 */
public class JavaNPE {
    public static void main(String[] args) {
        System.out.println(getInt());
    }

    public static int getInt() {
        Integer integer = null;
        return integer;
    }
}
