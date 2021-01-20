package com.practice.myRedis;

import redis.clients.jedis.Jedis;

/**
 * @author zhaoxu
 * @className JedisUtil
 * @projectName JavaConcentration
 * @date 2021/1/20 9:07
 */
public class JedisUtil {

    public static Jedis getInstance(){
        return new Jedis("localhost",6379);
    }
}
