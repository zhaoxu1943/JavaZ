package com.practice.JavaContainer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhaoxu
 * @className JavaStack
 * @projectName JavaConcentration

 * @date 2/19/2020 12:12 PM
 */
public class JavaStack {
    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList();
        stack.push("U");
        stack.push("n");
        stack.push("c");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push("e");
        stack.push("r");
        stack.push("t");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push("a");
        stack.pop();
        stack.push("i");
        stack.pop();
        stack.push("n");
        stack.push("t");
        stack.push("y");
        stack.pop();
        stack.pop();
        stack.push("-");
        stack.push("r");
        stack.push("u");
        stack.pop();
        stack.pop();
        stack.push("l");
        stack.push("e");
        stack.push("s");

        System.out.println(stack.toString());





    }
}
