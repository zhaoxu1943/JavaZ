package com.practice.JavaUtils;

import java.util.Scanner;

/**
 * @ClassName KeyboardEnter
 * @Description 键盘输入类
 * @Author zhaoxu
 * @Date 2019/11/7 22:31
 * @Version 1.0
 **/
public class KeyboardEnter {

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        String string = input.nextLine();
        input.close();
        System.out.println(string);
    }


}
