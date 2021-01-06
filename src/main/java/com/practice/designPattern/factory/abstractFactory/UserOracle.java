package com.practice.designPattern.factory.abstractFactory;

import com.concentration.entity.UserInfo;

import java.util.List;

/**
 * @author zhaoxu
 * @className UserOracle
 * @projectName JavaConcentration

 * @date 2/17/2020 10:34 PM
 */
public class UserOracle implements UserDB {


    @Override
    public void insert(List<UserInfo> userInfoList) {
        System.out.println("oracle insert executed!");
    }

    @Override
    public UserInfo getUserInfoById(String userId) {
        System.out.println("oracle select executed!");
        return null;
    }
}
