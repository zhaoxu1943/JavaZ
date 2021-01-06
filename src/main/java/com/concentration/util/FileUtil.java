package com.concentration.util;


/**
 * @author zhaoxu
 * @className FileUtil
 * @date 4/27/2020 5:44 PM
 */
public class FileUtil {

    /**
     * 判定是否为sql文件格式
     * @author zhaoxu
     * @param
     * @throws
     */
    public static boolean isSqlFile(String fileName) {
        String[] fileNameArr= fileName.split("\\.");
        //防止空指针,而且别再用==了..
        return "sql".equals(fileNameArr[1]);
    }

}
