package com.practice.JavaIO;

import java.io.*;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 10000 个随机数 每个一行
 * @author zhaoxu
 * @className MakeInsert10000Num
 * @projectName JavaConcentration
 * @date 2020/9/11 16:19
 */
public class MakeInsert10000Num {

  public static void main(String[] args) throws IOException {
    //文件目录
    String path = "C:\\Users\\zhaoxu\\Desktop\\test\\10000num.txt";
      File file = new File(path);
      //创建目录
      if(!file.exists()){
      System.out.println(file.getParentFile().mkdirs()?"创建了目录":"未创建目录");
      }
      //创建文件
    System.out.println(file.createNewFile()?"创建了文件":"未创建文件");


      //流写入文件
      FileWriter fileWriter = new FileWriter(file,true);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      Random random = new Random();
      //int类型的数字流,含首不含尾
      IntStream intStream = random.ints(0,500)
              //选取10000位
              .limit(10000);
      //输出
      intStream.forEach(i-> {
          try {
              bufferedWriter.write(String.valueOf(i));
              bufferedWriter.newLine();
          } catch (IOException e) {
              e.printStackTrace();
          }

      });
      bufferedWriter.flush();
      bufferedWriter.close();
      fileWriter.close();
  }
}
