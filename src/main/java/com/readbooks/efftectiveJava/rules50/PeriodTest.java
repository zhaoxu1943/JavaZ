package com.readbooks.efftectiveJava.rules50;

import java.util.Date;

/**
 * @author zhaoxu
 * @className PeriodTest
 * @projectName JavaConcentration

 * @date 4/18/2020 8:40 PM
 */
public class PeriodTest {

    public static void main(String[] args) throws InterruptedException {
        //测试使用我们创建的"不可变类"
        Date start = new Date();
        Thread.sleep(5000);
        Date end = new Date();
        //当引用类型传入方法,并不会修改其引用
        //exchangeTime(start,end);
        //会修改对象的field
        changeTime(start);

        Period period =new Period(start,end);

        System.out.println(period.getStart());


    }


    public static void exchangeTime(Date start,Date end) {
        Date date  = new Date();
        date =start;
        start=end;
        end=date;
    }


    public static void changeTime(Date date) {
        date.setYear(1878);
    }
}
