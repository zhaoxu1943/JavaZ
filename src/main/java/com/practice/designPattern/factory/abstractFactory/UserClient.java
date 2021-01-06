package com.practice.designPattern.factory.abstractFactory;

import com.concentration.entity.UserInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxu
 * @className UserDBbyRedis
 * @projectName JavaConcentration

 * @date 2/17/2020 3:27 PM
 */
public class UserClient {
    public static void main(String[] args) {

        //fake userInfo
        // in real program
        //maybe from websites
        List<UserInfo> userInfoList = new ArrayList<>(); ;
        //先初始化2个对象
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserId("0001");
        userInfo1.setUserName("zhaoxu");
        userInfo1.setAge(3);
        userInfo1.setPhoneNumber("18888888888");
        userInfo1.setSex("male");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserId("0002");
        userInfo2.setUserName("sisi");
        userInfo2.setAge(2);
        userInfo2.setPhoneNumber("16666666666");
        userInfo2.setSex("female");
        userInfoList.add(userInfo1);
        userInfoList.add(userInfo2);


        //no design pattern
        //test insert
//        UserRedis userRedis = new UserRedis();
//        userRedis.insert(userInfoList);

        //test select
//        UserInfo userInfos = userRedis.getUserInfoById("0001");
//        System.out.println( userInfos.getUserName());


        //easy factory
//        UserDBFactory userDBFactory = new UserDBFactory();
//        UserDB userDB =  userDBFactory.getUserDB("mysql");
//        userDB.insert(userInfoList);
//        System.out.println(userDB.getUserInfoById("0002").toString());

        //factory method
        IDBFactory dbFactory = new DBOracleFactory();


        UserDB userDB = dbFactory.getUserDB();
        userDB.insert(userInfoList);
        System.out.println(userDB.getUserInfoById("0002").toString());

        DepartmentDB departmentDB = dbFactory.getDepartmentDB();
        //departmentDB.insert();
        //departmentDB.getDepartmentInfoById();


        //if add Oracle DB in factory method ,just add,dont need edit

        //last one abstract factory ,more abstract than others





    }
}
