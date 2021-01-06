package com.practice.designPattern.factory.abstractFactory;

import com.concentration.entity.DepartmentInfo;

import java.util.List;

/**
 * @author zhaoxu
 * @className DepartmentMysql
 * @projectName JavaConcentration

 * @date 2/17/2020 11:12 PM
 */
public class DepartmentMysql implements DepartmentDB {
    @Override
    public void insert(List<DepartmentInfo> departmentInfoList) {

    }

    @Override
    public DepartmentInfo getDepartmentInfoById(String userId) {
        return null;
    }
}
