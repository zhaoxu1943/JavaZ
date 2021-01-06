package com.practice.ZLang;

/**
 * 自创编程语言
 * @author zhaoxu
 * @className ZLang
 * @projectName JavaConcentration
 * @date 2020/7/6 23:06
 */
public class ZLang {

    public static void main(String[] args) {
        //if不写大括号也不会报错
        if (0==0) System.out.println(312321);

        //switch 不写break 会进入下一个case
        int i = 1312;
        switch (i) {
            case 1:
                System.out.println("wdnma");
            case 2:
                System.out.println("djsioji");

        }
        String str = "{\n" +
                "  \"user\": \"zhaoxu\",\n" +
                "  \"age\": 1\n" +
                "}";
    }
}
