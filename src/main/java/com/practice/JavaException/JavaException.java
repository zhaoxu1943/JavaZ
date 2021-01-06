package com.practice.JavaException;

import com.concentration.entity.UserInfo;

/**
 * @author zhaoxu
 * @className JavaException
 * @projectName JavaConcentration
 * @date 2020/7/22 19:11
 */
public class JavaException {


    public static void main(String[] args) {
        testNPE();
    }

    private static  void testNPE() {
        testNPE1();
    }


    private static  void testNPE1() {
        testNPE2();
    }


    private static  void testNPE2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("11");
        userInfo.setUserName("zaox");
        //模拟异常
        userInfo = null;
        System.out.println(userInfo.getUserName());
    }






}
