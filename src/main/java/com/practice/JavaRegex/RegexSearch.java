package com.practice.JavaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhaoxu
 * @className RegexSearch
 * @projectName JavaConcentration
 * @description search subString in superString
 * core class java.util.regex.Pattern
 * core method:  Pattern.matches
 * @date 2/27/2020 9:48 AM
 */
public class RegexSearch {

    public static void main(String[] args) {
//        String text = "I am noob " +
//        "from runoob.com.";
//
//        String searchString = " oob";
//
//        System.out.println(searchStringByRegex(searchString,text));



        // 按指定模式在字符串查找
        String text = "This order was placed for QT3000! OK?";
        // * >=0
        //  + >=1
        //? 0|1  and fei tan xin
        String pattern = "(\\D*)(\\d+)(.*)";

        // get Pattern Object
        Pattern p = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = p.matcher(text);



        System.out.println("groupCount :" + m.groupCount());
        if (m.find( )) {
            //group(0)  represent all
            System.out.println("Found value: " + m.group(0) );
            //group shun xu an zuo kuo hao shun xu
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );

        } else {
            System.out.println("NO MATCH");
        }

        System.out.println(m.matches());
    }









    public static String searchStringByRegex(String subString,String superString) {
        String pattern = ".*" + subString + ".*";
        return Pattern.matches(pattern,superString)?"yes":"no";




    }






}
