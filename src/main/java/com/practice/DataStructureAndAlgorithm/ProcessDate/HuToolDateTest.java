package com.practice.DataStructureAndAlgorithm.ProcessDate;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * hutool Date 测试
 * @author zhaoxu
 * @className HuToolDateTest
 * @projectName JavaConcentration
 * @date 2020/10/26 18:37
 */
public class HuToolDateTest {


    public static void main(String[] args) {

    Date date =DateUtil.parse("2011-06-28");
        System.out.println(date);

        Date date1 = DateUtil.parse("2011-08-08 01:01:10");
        System.out.println(date1);


    }

}
