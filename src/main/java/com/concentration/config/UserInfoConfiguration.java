package com.concentration.config;

import com.concentration.entity.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoxu
 * @version 1.0
 * @className UserInfoConfiguration
 * @date 2019/12/22 9:37
 **/

@Configuration
public class UserInfoConfiguration {

    @Bean(name = "userBean")
    public UserInfo getUserInfo() {
        UserInfo userInfo =new UserInfo();
        userInfo.setUserId("0003");
        userInfo.setUserName("config工具人");
        return userInfo;
    }
}
