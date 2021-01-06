package com.practice.myRedis;
import com.alibaba.fastjson.JSON;
import com.concentration.entity.UserInfo;
import redis.clients.jedis.Jedis;

import javax.el.MethodNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxu
 * @version 1.0
 * @className UseJedis
 * @description 使用jedis原生操作redis
 * @date 2019/12/20 9:59
 **/
public class UseJedis {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //创建到aliyun的redis链接
        Jedis jedis = new Jedis("localhost",6379);
        //jedis.auth("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        List<UserInfo> userInfoList = new ArrayList<>();
        //序列化一个对象为JSON字符串
        //先初始化一个对象
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserId("0001");
        userInfo1.setUserName("test1");
        userInfo1.setAge(3);
        userInfo1.setPhoneNumber("18888888888");
        userInfo1.setSex("male");
        userInfoList.add(userInfo1);
        //先初始化一个对象
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserId("0002");
        userInfo2.setUserName("test2");
        userInfo2.setAge(2);
        userInfo2.setPhoneNumber("16666666666");
        userInfo2.setSex("female");
        userInfoList.add(userInfo2);




        //----------------------------
        //使用String结构缓存用户信息,这时比如有n个用户

        //引入fastjson并使用

        //创建一个keys的list方便取
        List<String> keysList = new ArrayList<>();
        for (UserInfo userInfo:userInfoList) {
            String jsonString = JSON.toJSONString(userInfo);
            //存入
            String key = "userinfo:";
            key = key + userInfo.getUserId();
            keysList.add(key);
            jedis.set(key,jsonString);
        }

        for (String key:keysList) {
            //取出并反序列化为对象
            String objStr = JSON.parseObject(jedis.get(key),UserInfo.class).toString();
            System.out.println(objStr);
        }

        //----------------------------
        //使用hash结构缓存用户信息,这时比如有n个用户,那么就要创建n个hash
        for (UserInfo userInfo:userInfoList) {
            String key = "muserinfo:";
            key = key + userInfo.getUserId();
            Class clazz= UserInfo.class;
            Field[] fields = clazz.getDeclaredFields();
            Map<String, String> value = new HashMap();
            for (Field field:fields) {
                // 取属性名
                String fieldName = field.getName();
                // 获取get方法名
                String getter = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                // 得到get方法对象
                Method method = clazz.getMethod(getter);
                // 通过属性的get方法取到当前goods对象的属性值
                String fieldValue = method.invoke(userInfo)+"";
                value.put(fieldName, fieldValue);
            }
            jedis.hmset(key,value);
        }




    }
}
