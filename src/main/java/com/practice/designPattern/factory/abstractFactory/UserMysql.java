package com.practice.designPattern.factory.abstractFactory;

import com.concentration.entity.UserInfo;

import java.sql.*;
import java.util.List;

/**
 * @author zhaoxu
 * @className UserDBMysql
 * @projectName JavaConcentration

 * @date 2/17/2020 5:00 PM
 */
public class UserMysql implements UserDB{

    public static final String URL = "jdbc:mysql://localhost:3306/java_concentration";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    private static Connection conn = null;


    //create connection
    static{
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void insert(List<UserInfo> userInfoList)  {


        //sql
        String sql = "INSERT INTO user_info(user_id, user_name, age,sex, phoneNumber)"
                +"values("+"?,?,?,?,?)";
        //预编译
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
            for (UserInfo userinfo:userInfoList) {

                ptmt.setString(1, userinfo.getUserId());
                ptmt.setString(2, userinfo.getUserName());
                ptmt.setInt(3, userinfo.getAge());
                ptmt.setString(4, userinfo.getSex());
                ptmt.setString(5, userinfo.getPhoneNumber());


                //执行
                ptmt.execute();
                System.out.println("sql executed!");
            }
            //传参

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public UserInfo getUserInfoById(String userId) {
        //sql
        String sql = "SELECT * FROM user_info WHERE user_id ="+"?";
        UserInfo userInfo = new UserInfo();
        //预编译
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
            ptmt.setString(1, userId);

            //执行
            ResultSet rs = ptmt.executeQuery();

            while(rs.next()){
                userInfo.setUserId(rs.getString("user_id"));
                userInfo.setUserName(rs.getString("user_name"));
                userInfo.setAge(rs.getInt("age"));
                userInfo.setSex(rs.getString("sex"));
                userInfo.setPhoneNumber(rs.getString("phoneNumber"));
            }
            } catch (SQLException e) {
            e.printStackTrace();
        }return userInfo;
    }
}
