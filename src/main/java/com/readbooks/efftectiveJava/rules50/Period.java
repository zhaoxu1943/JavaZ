package com.readbooks.efftectiveJava.rules50;

import java.util.Date;

/**
 * @author zhaoxu
 * @className Period
 * @projectName JavaConcentration

 * @date 4/18/2020 8:25 PM
 */
public final class Period {

    private final Date start;
    private final Date end;

   /**
    * @author zhaoxu
    * @description 创建的"不可变类"的构造器
    * @params Date start
    * @params Date end ,must not precede start
    * @throws IllegalArgumentException if start after end;
    * @throws NullPointerException if start or end is Null

    */
//    public Period(Date start, Date end) {
//        if (start==null||end==null) {
//            throw new NullPointerException("start或end不能为空值");
//        }
//        //Date类中比较时间先后的方法,0则相等,返回值>0则比参数大(时间靠后),返回值<0则比参数小(时间靠前)
//        if (start.compareTo(end)>0) {
//            throw new IllegalArgumentException(start+" after "+end);
//        }
//        this.start = start;
//        this.end = end;
//    }


    /**
     * @author zhaoxu
     * @description 创建的"不可变类"的构造器
     * @params Date start
     * @params Date end ,must not precede start
     * @throws IllegalArgumentException if start after end;
     * @throws NullPointerException if start or end is Null
     * 为了保护可变类型Date,实行了保护性拷贝
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());


        //Date类中比较时间先后的方法,0则相等,返回值>0则比参数大(时间靠后),返回值<0则比参数小(时间靠前)
        if (this.start.compareTo(this.end)>0) {
            throw new IllegalArgumentException(start+" after "+end);
        }

    }










    public  Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
