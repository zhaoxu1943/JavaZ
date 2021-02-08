package com.practice.a.life.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhaoxu
 * @className A
 * @projectName JavaConcentration
 * @date 2020/7/10 9:33
 */
public class A {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        int value = localDate.getDayOfWeek().getValue();
        System.out.println("> now:"+localDate+" dayOfWeek:"+value);
        LocalDate sepDate = LocalDate.of(2020,9,1);


        System.out.println("only have "+ ChronoUnit.DAYS.between(localDate,sepDate)+ " days");

        //创建Calendar实例
        Calendar calender =Calendar.getInstance();
        calender.setTime(new Date());
        //输出今年的多少天 Type may be primitive
        int dayOfYear = calender.get(Calendar.DAY_OF_YEAR);
        int weekOfYear = calender.get(Calendar.WEEK_OF_YEAR);
        System.out.println("dayOfYear:"+dayOfYear);
        System.out.println("weekOfYear:"+weekOfYear);

        switch(value) {
            case 1:
                System.out.println(localDate+"~"+localDate.plusDays(6));
                break;
            case 2:
                System.out.print(localDate.minusDays(1) + "~" + localDate.plusDays(5));
                break;
            case 3:
                System.out.print(localDate.minusDays(2) + "~" + localDate.plusDays(4));
                break;
            case 4:
                System.out.print(localDate.minusDays(3) + "~" + localDate.plusDays(3));
                break;
            case 5:
                System.out.print(localDate.minusDays(4) + "~" + localDate.plusDays(2));
                break;
            case 6:
                System.out.print(localDate.minusDays(5) + "~" + localDate.plusDays(1));
                break;
            case 7:
                System.out.print(localDate.minusDays(6) + "~" + localDate);
                break;
            default:
                System.out.print("not a normal day!");
        }

    }


}
