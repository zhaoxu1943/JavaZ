package com.practice.DataStructureAndAlgorithm.ProcessString;

import cn.hutool.core.util.StrUtil;

/**
 * @author zhaoxu
 * @className SplitString
 * @projectName JavaConcentration
 * @date 2020/11/9 16:19
 */
public class SplitString {
    public static void main(String[] args) {
        String s= "SSOINFO=\"<url>https://10.97.187.139:8443/index.jsp?language=0</url>\"";
        String[] s1 = s.split("=",2);
        for (String s2: s1) {
            System.out.println(s2);
        }
    }
}
