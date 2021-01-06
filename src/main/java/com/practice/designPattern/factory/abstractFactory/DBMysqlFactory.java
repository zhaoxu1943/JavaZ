package com.practice.designPattern.factory.abstractFactory;

/**
 * @author zhaoxu
 * @className UserDBMysqlFactory
 * @projectName JavaConcentration

 * @date 2/17/2020 10:27 PM
 */
public class DBMysqlFactory implements IDBFactory {
    @Override
    public DepartmentDB getDepartmentDB() {
        return null;
    }

    @Override
    public UserDB getUserDB() {
        return new UserMysql();


    }
}
