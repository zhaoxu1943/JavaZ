package com.concentration.cache;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

/**
 * 缓存中心
 * 提高查询效率
 *
 * @author zhaoxu
 * @className CacheCenter
 * @projectName JavaConcentration
 * @date 2021/1/19 13:29
 */
public class CacheCenter {



    public static void main(String[] args) {
        //缓存过期时间3600秒 000
        TimedCache<String,String> timedCache =  CacheUtil.newTimedCache(-1);

    }



}
