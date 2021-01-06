//package com.practice.designPattern.factory.abstractFactory;
//
///**
// * @author zhaoxu
// * @className UserDBFactory
// * @projectName JavaConcentration
//
// * @date 2/17/2020 6:04 PM
// */
//public class UserDBFactory {
//
//    public   UserDB userDB;
//
//    public  UserDB getUserDB(String s) {
//        switch(s){
//            case "mysql":
//                userDB = new UserMysql();
//                break;
//            case "redis":
//                userDB = new UserRedis();
//                //must add "break" in every switch,or will return the last one
//                break;
//        }
//        return userDB;
//    }
//
//
//
//
//}
