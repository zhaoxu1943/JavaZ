package com.practice.a.life.time;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 计算下班时间
 * @author zhaoxu
 * @className FreeTimeCaculator
 * @projectName JavaConcentration
 * @date 2020/9/4 9:31
 */
public class FreeTimeCalculator {



  public static void main(String[] args) {
      //最早上班时间
      LocalTime earliestWorkTime = LocalTime.of(8,0);
      //下班时间
      LocalTime earliestLeaveTime;
      //当前时间,不包含毫秒数
      LocalTime now = LocalTime.now().withNano(0);
      if (now.isAfter(earliestWorkTime)){
          earliestLeaveTime = now.plusHours(8).plusMinutes(32);
      }else{
          earliestLeaveTime = earliestWorkTime.plusHours(8).plusMinutes(32);
      }

      System.out.println(LocalDate.now()+"下班时间为"+ earliestLeaveTime+",到工位时间为"+now);
  }
}
