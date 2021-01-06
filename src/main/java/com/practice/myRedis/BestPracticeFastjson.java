package com.practice.myRedis;

import com.alibaba.fastjson.JSON;
import com.concentration.entity.UserInfo;

/**
 * @author zhaoxu
 * @version 1.0
 * @className BestPracticeFastJson
 * @description FastJson最佳实践
 * @date 2019/12/20 10:41
 **/
public class BestPracticeFastjson {


    public static void main(String[] args) {

        //序列化一个对象为JSON字符串
        //先初始化一个对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("0001");
        userInfo.setUserName("zhaoxu");
        userInfo.setAge(3);
        userInfo.setPhoneNumber("18888888888");
        userInfo.setSex("male");
        //引入fastjson并使用
        String jsonString = JSON.toJSONString(userInfo);
        System.out.println(jsonString);


        //进行反序列化
        UserInfo userInfo1 = JSON.parseObject(jsonString,UserInfo.class);
        System.out.println(userInfo1.getUserName());
    }


}
