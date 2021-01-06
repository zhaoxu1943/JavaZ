package com.concentration.dao;

import com.concentration.entity.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhaoxu
 * @className UserDAO
 * @projectName JavaConcentration
 * @date 3/23/2020 9:10 PM
 */
public interface UserMapper {

    /**
     * 返回数据列表
     *
     * @return
     */

    List<HashMap> findAllUsers();

    /**
     * 添加
     *
     * @param userInfo
     * @return
     */
    int insertUser(UserInfo userInfo);

    /**
     * 修改
     *
     * @param userInfo
     * @return
     */
    int updUser(UserInfo userInfo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delUser(Integer id);
}
