package com.practice.JavaTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author zhaoxu
 * @className JavaTime
 * @projectName JavaConcentration
 * @date 2020/6/4 20:15
 */
public class JavaTime {


    public static void main(String[] args) {
        LocalDateTime end  = LocalDateTime.now();
        LocalDateTime start =  end.minusMinutes(20);
        DateTimeFormatter  dateTimeFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(start.format(dateTimeFormatter));
        System.out.println(end.format(dateTimeFormatter));
    }

}
