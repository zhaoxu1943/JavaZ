package com.practice.DataStructureAndAlgorithm;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.practice.JavaIO.MakeInsert10000Num;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 统计数字出现次数
 * 统计词频前k大
 * @author zhaoxu
 * @className CountNumOccurTimes
 * @projectName JavaConcentration
 * @date 2020/9/11 17:12
 */
public class CountNumOccurTimes {

  public static void main(String[] args) throws IOException {
    //首先创建一个10000数字的文件
      MakeInsert10000Num.main(new String[0]);
    //创造容器存他们
      List<Integer> integerList = Lists.newArrayList();
      //进行文件的读取
      String path = "C:\\Users\\zhaoxu\\Desktop\\test\\10000num.txt";

      File file=new File(path);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
      //读取远程文件
      String line;
      while ((line = bufferedReader.readLine()) != null) {
          //排除blank数据项
          if (StringUtils.isNotBlank(line)) {
              integerList.add(Integer.valueOf(line));
          }
      }


      //开始进行次数统计
      Map<Integer,Integer> timesMap = Maps.newHashMap();

      integerList.forEach(integer -> {
          if (timesMap.containsKey(integer)){
              timesMap.put(integer,timesMap.get(integer)+1);
          }else{
              timesMap.put(integer,1);
          }
      });

      //根据次数排序
      List<Map.Entry<Integer,Integer>> entryList = Lists.newArrayList(timesMap.entrySet());
      Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
          @Override
          public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
              return o2.getValue()-o1.getValue();
          }
      });

    for (int i = 0; i < 10; i++){
      System.out.println(entryList.get(i).getKey()+"出现"+entryList.get(i).getValue()+"次,排名第"+(i+1));
    }
  }


}
