package com.practice.DataStructureAndAlgorithm.ProcessString;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;


/**
 * @author zhaoxu
 * @className GuavaString
 * @projectName JavaConcentration
 * @date 2020/5/15 16:09
 */
public class GuavaString {
    public static void main(String[] args) {
        String s = "abd";
        System.out.printf(cast(s));
    }

    private static String cast(String string) {
        return StringUtils.capitalize(string);
    }
}
