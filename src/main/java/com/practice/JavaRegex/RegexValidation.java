package com.practice.JavaRegex;

import java.util.regex.Pattern;

/**
 * @author zhaoxu
 * @className RegexPasswordValidation
 * @projectName JavaConcentration

 * @date 2/26/2020 11:45 AM
 */
public class RegexValidation {

    public static void main(String[] args) {

        //userName
        String userName1 = "test123";
        System.out.println(userNameValidation(userName1));
        //qqNumber
        String qqNumber = "3218903";
        System.out.println(QQNumberValidation(qqNumber));

    }


//    public boolean judgePasswordRegex (String Password) {
//        //write pattern
//
//        //matches
//    }


    public static String userNameValidation (String userName) {
        // a-z 0-9 - and _ ,length 6-10
        String pattern ="^[a-z0-9_-]{6,10}$";
        return Pattern.matches(pattern,userName)?"yes":"no";
    }


    public static String QQNumberValidation (String userName) {
        // a-z 0-9 - and _ ,length 6-10
        String pattern ="[1-9][0-9]{4,}";
        return Pattern.matches(pattern,userName)?"yes":"no";
    }


    public static String IPValidation (String userName) {
        // a-z 0-9 - and _ ,length 6-10
        String pattern ="(\\d{1,3}\\.){3}\\d{1,3}";
        return Pattern.matches(pattern,userName)?"yes":"no";
    }



}
