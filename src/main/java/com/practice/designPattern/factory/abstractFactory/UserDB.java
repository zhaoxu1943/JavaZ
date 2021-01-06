package com.practice.designPattern.factory.abstractFactory;

import com.concentration.entity.UserInfo;

import java.util.List;

/**
 * @author zhaoxu
 * @className UserDB
 * @projectName JavaConcentration
 * @description db interface
 * @date 2/17/2020 5:06 PM
 */
public interface UserDB {

    void insert(List<UserInfo> userInfoList);

    UserInfo getUserInfoById (String userId);
}
