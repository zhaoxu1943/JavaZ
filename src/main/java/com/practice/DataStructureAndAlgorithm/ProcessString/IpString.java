package com.practice.DataStructureAndAlgorithm.ProcessString;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhaoxu
 * @className IpString
 * @projectName JavaConcentration
 * @date 2020/8/25 15:18
 */
public class IpString {



    public static void main(String[] args) {




        String sd= "局/处/科";
        String[] s1  = sd.split("/");
        System.out.println(1);




        //
        String ip = "321321///321321";
        //如果输入limit数值等于0,则会执行切割无限次并且去掉该数组最后的所有空字符串
        String[] ipArr = ip.split("\\.");
        LinkedList<String> linkedList = Lists.newLinkedList();

        for (String s :ipArr ) {
            if (StringUtils.isNotEmpty(s)){
                linkedList.add(s);
            }

        }



        System.out.println(ipArr.length);
        print(ipArr);
        System.out.println(linkedList.size());
    linkedList.forEach(System.out::println);


  }



   private static void print(String[] arr){
        for (String s :arr ) {
            System.out.println(s);
        }
   }
}
