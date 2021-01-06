package com.concentration.controller;

import com.concentration.dao.UserMapper;
import com.concentration.entity.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhaoxu
 * @className UserController
 * @projectName JavaConcentration
 * @date 3/23/2020 9:19 PM
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @GetMapping("/queryAll")
    public List<HashMap> queryAll() {
        return userMapper.findAllUsers();
    }




}
