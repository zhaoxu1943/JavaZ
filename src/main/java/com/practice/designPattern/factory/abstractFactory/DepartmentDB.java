package com.practice.designPattern.factory.abstractFactory;

import com.concentration.entity.DepartmentInfo;
import com.concentration.entity.UserInfo;

import java.util.List;

/**
 * @author zhaoxu
 * @className DepartmentDb
 * @projectName JavaConcentration

 * @date 2/17/2020 11:13 PM
 */
interface DepartmentDB {
    void insert(List<DepartmentInfo> departmentInfoList);

    DepartmentInfo getDepartmentInfoById (String userId);
}
