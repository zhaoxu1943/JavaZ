package com.practice.JavaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex {

    public static void main(String[] args) {

        //learn from https://github.com/ziishaned/learn-regex/blob/master/README.md
        //  . full stop matches any single character
        String pattern1 = ".ar";
        String text1 = "car";

        System.out.println(". " + Pattern.matches(pattern1,text1));





        //for search,if something  exists in text
        String text =  "This is the text to be searched " +
                "for occurrences of the http:// http:// pattern.";

        String pattern = ".*http://.*";
        //Using for judge exists,cannot judge how many times
        System.out.println("matches : " +Pattern.matches(pattern,text));



        //Character set
        System.out.println("Character set: "+"Zhaoxu".matches("[Zz]haoxu"));
        System.out.println("Character set: "+"zhaoxu".matches("[Zz]haoxu"));
        //period in Character Set means literal period,not any word,for example
        System.out.println("Character set: "+"xu.".matches("xu[.]"));
        System.out.println("Character set: "+"xuo".matches("xu[.]"));

        //Negated character set
        System.out.println("Negated Character set: "+"zhaoxu".matches("[^T]haoxu"));
        System.out.println("Negated Character set: "+"Thaoxu".matches("[^T]haoxu"));

        // \d any number  \s any blank \w any word
        System.out.println("any : "+"Zhaoxu".matches("\\w+"));
        System.out.println("any : "+"Zhaoxu".matches("\\s+"));
        System.out.println("any : "+"Zhaoxu".matches("\\d+"));


        //border ^This is a single line$
        System.out.println("border : "+"Zhaoxu".matches("[a-zA-Z]"));







        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));

        //Using Pattern
        System.out.println(Pattern.matches("this is text","this is text"));
    }
}
