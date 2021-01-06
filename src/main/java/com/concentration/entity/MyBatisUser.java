package com.concentration.entity;

import java.util.Objects;

/**
 * @author zhaoxu
 * @className MybatisUser
 * @projectName JavaConcentration

 * @date 3/23/2020 11:34 AM
 */
public class MyBatisUser {

    public Integer userId;

    public String userName;

    public MyBatisUser(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyBatisUser that = (MyBatisUser) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "MybatisUser{" +
                "userId='" + userId + '\'' +
                ", userName=" + userName +
                '}';
    }
}
