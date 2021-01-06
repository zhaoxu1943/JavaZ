package com.practice.JavaException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * 抛出断言异常
 * @author zhaoxu
 * @className JavaAssertionError
 * @projectName JavaConcentration
 * @date 2020/7/24 8:43
 */
public class JavaAssertionError {

    public static void main(String[] args) {
        String str1 = "zhaoxu";
        String str2 = "jusi";

        judgeEqual_1(str1,str2);
//        judgeEqual_2(str1,str2);
    }



    private static void judgeEqual_1(String str1,String str2) {
        if (StringUtils.isNotEmpty(str1)&&str1.equals(str2)){
            System.out.println("相等!");
        } else{
            System.exit(3213123);
            throw new AssertionError("这俩字符串不相等!");
        }
    }


    private static void judgeEqual_2(String str1,String str2) {
        Assert.isTrue(StringUtils.isNotEmpty(str1)&&str1.equals(str2),"这俩字符串不相等!");
    }



}
