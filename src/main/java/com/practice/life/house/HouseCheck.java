package com.practice.life.house;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.practice.life.house.House;
import com.practice.life.house.Subway;

import java.util.HashMap;

/**
 * 房屋检查程序
 *
 * @author zhaoxu
 * @className HouseCheck
 * @projectName JavaConcentration
 * @date 2021/1/28 10:39
 */
public class HouseCheck {

  public static final Integer GOOD_TAG = 3;

  public static final Integer NORMAL_TAG = 2;

  public static final Integer BAD_TAG = 1;

  public static final Integer UNKNOWN_TAG = -1;

  public static void main(String[] args) {

    House house = new House();
    // 区域
    house.setRegion("回龙观");
    // 小区名
    house.setCommunityName("龙回苑");
    // 地铁信息
    HashMap<String, Subway> subwayMap = Maps.newHashMap();
    Subway subway8 = new Subway();
    subway8.setDistance(800);
    subway8.setIsHavingStartingCar(GOOD_TAG);
    Subway subway13 = new Subway();
    subway13.setDistance(900);
    subway13.setIsHavingStartingCar(BAD_TAG);
    subwayMap.put("8", subway8);
    subwayMap.put("13", subway13);
    house.setSubwayMap(subwayMap);
    // 具体门牌号
    house.setAddress("3-1-201");
    // 小区内部环境
    house.setCommunityInnerEnvironment(GOOD_TAG);
    // 小区外部环境
    house.setCommunityOutSideEnvironment(GOOD_TAG);
    // 该楼总楼层数
    house.setTotalFloor(6);
    // 房房具体楼层数
    house.setFloor(4);
    // 是否有电梯
    house.setIsElevator(BAD_TAG);
    // 是否把边/冷山
    house.setIsOnTheSideOrCodeWall(NORMAL_TAG);
    // 户型
    house.setUnitType(GOOD_TAG);
    // 面积
    house.setArea(77);
    // 临街
    house.setIsOnStreet(BAD_TAG);
    // 客厅是否转卧室
    house.setIsLivingRoomAsBedRoom(GOOD_TAG);
    // 采光

    house.setLighting(NORMAL_TAG);
    // 学校质量
    house.setSchoolQuality(NORMAL_TAG);
    // 装修
    house.setDecoration(BAD_TAG);

    String jsonString = JSON.toJSONString(house);
    System.out.println(jsonString);
  }


}
