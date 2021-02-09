package com.practice.database;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.ds.DataSourceWrapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * 学习mysql数据库使用的数据库数据插入程序
 *
 * @author zhaoxu
 * @className DataInsert
 * @projectName JavaConcentration
 * @date 2021/2/9 8:58
 */
public class DataInsert {






  public static void main(String[] args) throws SQLException {
    // 使用HUTool
    // 数据源默认使用db.setting配置文件

    for (int i = 0; i <10000 ; i++) {
      Db.use().insert(Entity.create("single_table")
              .set("key1",getRandomString())
              .set("key2",getRandomInt())
              .set("key3",getRandomString())
              .set("key_part1",getRandomString())
              .set("key_part2",getRandomString())
              .set("key_part3",getRandomString())
              .set("common_field",getRandomString())
      );
    }

  }


  private static int getRandomInt(){
    int[] randomArr = NumberUtil.generateRandomNumber(0,100000000,1);
    return randomArr[0];
  }

  /**
   * 得到随机不重复的字符串
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private static String getRandomString(){
    return  IdUtil.fastSimpleUUID();

  }


}
