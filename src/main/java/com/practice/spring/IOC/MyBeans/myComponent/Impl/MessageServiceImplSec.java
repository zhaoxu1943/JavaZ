package com.practice.spring.IOC.MyBeans.myComponent.Impl;
import com.practice.spring.IOC.MyBeans.myComponent.MessageService;


/**
 * @author zhaoxu
 * @className MessageServiceImplSec
 * @projectName JavaConcentration

 * @date 3/10/2020 4:22 PM
 */

public class MessageServiceImplSec implements MessageService {
    @Override
    public String getMessage() {
        return "Hello IOC 2nd!";
    }
}
