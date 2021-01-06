package com.practice.designPattern.factory.abstractFactory;

import com.alibaba.fastjson.JSON;
import com.concentration.entity.UserInfo;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zhaoxu
 * @className UserClient
 * @projectName JavaConcentration
 * @date 2/17/2020 3:37 PM
 */
public class UserRedis implements UserDB{

     public static Jedis jedis;


    /**
     * @author zhaoxu
     * @description  init redis when class init
     * @params
     */
    static {
        jedis = new Jedis("localhost",6379);
        jedis.auth("root");
    }



   /**
    * @author zhaoxu
    * @description  insert object userInfoList to redis db
    * @params userInfo
    */
   @Override
    public void insert(List<UserInfo> userInfoList) {
        for (UserInfo userInfo:userInfoList){
            jedis.set("userinfo:"+userInfo.userId, JSON.toJSONString(userInfo));
        }
    }

    /**
     * @author zhaoxu
     * @description
     * @params
     */
    @Override
    public UserInfo getUserInfoById (String id) {
        String userInfoJSON = jedis.get("userinfo:"+id);
        return JSON.parseObject(userInfoJSON,UserInfo.class);
    }


}
