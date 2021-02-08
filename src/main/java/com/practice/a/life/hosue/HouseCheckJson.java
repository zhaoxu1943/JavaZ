package com.practice.a.life.hosue;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static com.practice.a.life.hosue.HouseCheck.*;

/**
 * @author zhaoxu
 * @className HouseCheckJson
 * @projectName JavaConcentration
 * @date 2021/1/28 15:51
 */
public class HouseCheckJson {

  private static String computerUserName = "*";

  public static void main(String[] args) {
      HouseCheckJson houseCheckJson = new HouseCheckJson();
      String filePath = "C:\\Users\\"+computerUserName+"\\OneDrive\\生活\\house\\feng3.json";
      houseCheckJson.processJson(filePath);
  }

  /**
   * json的处理
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private void processJson(String filePath){
      File file = new File(filePath);
      //parse json file to json String
      String originJsonString = FileReader.create(file, Charset.defaultCharset()).readString();
      //拿到house对象
      House house = JSON.parseObject(originJsonString,House.class);
      calculateScore(house);
  }

  /**
   * 进行评分的计算
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private void calculateScore(House house) {
      Double score = 0.0;

      StringBuffer stringBuffer = new StringBuffer();

      stringBuffer.append(house.getRegion()+"-"+house.getCommunityName()+"-"+house.getAddress()+"房屋报告:");
      stringBuffer.append("\n");
      stringBuffer.append("时间:"+ DateUtil.now());
      stringBuffer.append("\n");

      //地铁评分
      HashMap<String, Subway> subwayMap = house.getSubwayMap();

      for (Map.Entry entry:subwayMap.entrySet()) {
          String subwayName = String.valueOf(entry.getKey());
          Subway subway = (Subway) entry.getValue();
          //临近8,且有始发
          if ("8".equals(subwayName)&&subway.getDistance()<1000&& subway.getIsHavingStartingCar().equals(GOOD_TAG)){
              score = score+GOOD_TAG;
              stringBuffer.append("临近8,且有始发");
              stringBuffer.append("\n");
          }
          //临近8,没有始发
          if ("8".equals(subwayName)&&subway.getDistance()<1000&& subway.getIsHavingStartingCar().equals(HouseCheck.BAD_TAG)){
              score = score+NORMAL_TAG;
              stringBuffer.append("临近8,没有始发");
              stringBuffer.append("\n");
          }
          //临近13
          if ("13".equals(subwayName)&&subway.getDistance()<1500){
              score = score+GOOD_TAG;
              stringBuffer.append("临近13");
              stringBuffer.append("\n");
          }
          //临近5
          if ("5".equals(subwayName)&&subway.getDistance()<1500){
              score = score+ BAD_TAG;
              stringBuffer.append("临近5");
              stringBuffer.append("\n");
          }
      }


      // 小区内部环境评分
      score = score+house.getCommunityInnerEnvironment()*1;
      stringBuffer.append("小区内部环境评分"+house.getCommunityInnerEnvironment());
      stringBuffer.append("\n");
      // 小区外部环境评分
      score = score+house.getCommunityOutSideEnvironment()*1;
      stringBuffer.append("小区外部环境评分"+house.getCommunityInnerEnvironment());
      stringBuffer.append("\n");
      // 楼层评分
      Integer floor = house.getFloor();
      Integer totalFloor = house.getTotalFloor();
      Integer isElevator =house.getIsElevator();
      if (1< floor&&floor<totalFloor&&floor<4&&(isElevator.equals(BAD_TAG))){
          score = score+ GOOD_TAG;
          stringBuffer.append("无电梯,不顶层,不底层,中间楼层且小于4层");
          stringBuffer.append("\n");
      }else if((isElevator.equals(GOOD_TAG))){
          score = score+ GOOD_TAG;
          stringBuffer.append("有电梯");
          stringBuffer.append("\n");
       }else{
          stringBuffer.append("无电梯,楼层为"+floor+",总层数为"+totalFloor+",不符合要求");
          stringBuffer.append("\n");
      }
      // 是否把边/冷山
      score = score+house.getIsOnTheSideOrCodeWall()*1;
      stringBuffer.append("是否把边/冷山评分"+house.getCommunityInnerEnvironment());
      stringBuffer.append("\n");

      // 户型评分
      score = score+house.getUnitType()*2;
      stringBuffer.append("户型评分"+house.getUnitType());
      stringBuffer.append("\n");

    //面积评分
      Integer area = house.getArea();
      if (area>90){
          score = score+GOOD_TAG;
          stringBuffer.append("面积"+area+"评分"+GOOD_TAG);
          stringBuffer.append("\n");
      }else{
          score = score+NORMAL_TAG;
          stringBuffer.append("面积"+area+"评分"+NORMAL_TAG);
          stringBuffer.append("\n");
      }
      //临街评分
      score = score+house.getIsOnStreet()*1;
      stringBuffer.append("是否临街评分"+house.getIsOnStreet());
      stringBuffer.append("\n");

      //临街评分
      score = score+house.getIsOnStreet()*1;
      stringBuffer.append("是否临街评分"+house.getIsOnStreet());
      stringBuffer.append("\n");

      //客厅是否转卧室
      score = score+house.getIsLivingRoomAsBedRoom()*1;
      stringBuffer.append("客厅是否转卧室评分"+house.getIsLivingRoomAsBedRoom());
      stringBuffer.append("\n");


      //采光
      score = score+house.getLighting()*1;
      stringBuffer.append("采光评分"+house.getLighting());
      stringBuffer.append("\n");


      // 学校质量
      score = score+house.getSchoolQuality()*1;
      stringBuffer.append("学校质量评分"+house.getSchoolQuality());
      stringBuffer.append("\n");

      // 装修
      score = score+house.getDecoration()*1;
      stringBuffer.append("装修评分"+house.getDecoration());
      stringBuffer.append("\n");

      System.out.println(stringBuffer.toString());
      System.out.println("最终评分"+score);
  }



}
