package com.concentration.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author zhaoxu
 * @version 1.0
 * @className UserInfo
 * @description 用户信息类
 * @date 2019/12/20 9:28
 **/
public class UserInfo implements Serializable {


    private static final long serialVersionUID = 9185285943269046738L;

    public String userId;
    public String userName;
    public int age;
    public String sex;
    public String phoneNumber;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) o;
        return age == userInfo.age &&
                userId.equals(userInfo.userId) &&
                userName.equals(userInfo.userName) &&
                Objects.equals(sex, userInfo.sex) &&
                Objects.equals(phoneNumber, userInfo.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, age, sex, phoneNumber);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
