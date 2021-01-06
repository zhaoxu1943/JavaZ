package com.practice.mybatis;

import com.concentration.entity.MyBatisUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhaoxu
 * @className MybatisTest
 * @projectName JavaConcentration

 * @date 3/23/2020 11:38 AM
 */
public class MybatisTest {
    public static void main(String[] args) {
        try {
            
            //读取mybatis-config文件
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //初始化mybatis,使用SqlSessionFactoryBuilder创建SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"mysql");

            //创建sqlsession实例
            SqlSession sqlSession = sqlSessionFactory.openSession();

            MyBatisUser mybatisUser = new MyBatisUser(1,"zhaoxu");
            sqlSession.insert("com.concentration.mapper.MybatisUserMapper.insertInto",mybatisUser);
            sqlSession.commit();
            sqlSession.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
