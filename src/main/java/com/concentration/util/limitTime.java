package com.concentration.util;

import java.time.LocalTime;

/**
 *
 * 限定执行时间
 * @author zhaoxu
 * @className limitTime
 * @projectName JavaConcentration
 * @date 2020/12/2 20:04
 */
public class limitTime {


    public static void main(String[] args) {
        if(timeLimit()){
            System.out.println("时间合适!");
        }else{
            System.out.println("时间不合适!");
        }
    }




    private static boolean timeLimit() {
        LocalTime timeNow = LocalTime.now();
        LocalTime startTime = LocalTime.of(20,0);
        LocalTime endTime = LocalTime.of(21,30);
        if (startTime.isBefore(endTime)&&timeNow.isAfter(startTime)&&timeNow.isBefore(endTime)){
            return true;
        }else{
            return false;
        }
    }

}
