package com.practice.spring.IOC.MyBeans.myComponent.Impl;


import com.practice.spring.IOC.MyBeans.POJO.MySpringBean;
import com.practice.spring.IOC.MyBeans.myComponent.MessageService;


/**
 * @author zhaoxu
 * @className MessageServiceImpl
 * @projectName JavaConcentration

 * @date 3/10/2020 4:14 PM
 */

public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "Hello IOC!";
    }

    private MySpringBean mySpringBean;

    public void setMyspringbeancd(MySpringBean myspringbeancd) {
        this.mySpringBean= myspringbeancd;
    }

    public MySpringBean getMyspringbeancd() {
            return mySpringBean;
    }

}
