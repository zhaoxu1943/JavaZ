package com.practice.JavaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhaoxu
 * @className RegexReplace
 * @projectName JavaConcentration
 * @description split and replace
 * @date 2/27/2020 9:48 AM
 */
public class RegexReplace {
    public static void main(String[] args) {
        String text = "ni hao ewo~";

        String pattern = "hao";

        //first make Mather Object
        Pattern p  = Pattern.compile(pattern);
        Matcher matcher= p.matcher(text);


        //Pattern.spilt
        String[] s1= p.split(text);

        for (String s: s1
             )
            System.out.println(s);{

        }





        //mather.replace
        if (matcher.find()){
           String s=  matcher.replaceAll("pghyug");
           System.out.println(s);
        }



        //output location
        if (matcher.find()){
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }





    }






}
