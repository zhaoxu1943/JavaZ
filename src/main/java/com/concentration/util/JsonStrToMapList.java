package com.concentration.util;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

/**
 * 读取json并转为map的list
 * @author zhaoxu
 * @className JsonStrToMapList
 * @projectName JavaConcentration
 * @date 2020/11/30 10:28
 */
public class JsonStrToMapList {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\*.txt";
        File file = new File(filePath);
        JSONObject json = JSONUtil.readJSONObject(file, Charset.defaultCharset());
        List<HashMap<String,String>> mapList = (List<HashMap<String, String>>) json.get("authorization_relation");
    }
}
