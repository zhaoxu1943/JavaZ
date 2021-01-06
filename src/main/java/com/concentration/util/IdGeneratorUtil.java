package com.concentration.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author zhaoxu
 * @className IdGeneratorUtil
 * @projectName JavaConcentration
 * @date 2020/6/8 16:26
 */
public class IdGeneratorUtil {

    public static String getId32ByMD5(String msg){
        return DigestUtils.md5Hex(msg);
    }

    public static String getId32ByMD5(Date date){
        return getId32ByMD5(String.valueOf(date.getTime()));
    }

    public static String getUUID32(){
        return UUID.randomUUID().toString().substring(0, 32);
    }

    public static void main(String[] args) {
        System.out.println(getId32ByMD5("赵旭zhao我带我去xu1943"));
        System.out.println("24294de39d2217b4a049c87301545bb4".equals(getId32ByMD5("赵旭zhao我带我去xu1943")));
    }

}
