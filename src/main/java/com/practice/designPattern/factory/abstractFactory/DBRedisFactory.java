package com.practice.designPattern.factory.abstractFactory;

/**
 * @author zhaoxu
 * @className UserDBRedisFactory
 * @projectName JavaConcentration

 * @date 2/17/2020 10:27 PM
 */
public class DBRedisFactory implements IDBFactory {
    @Override
    public UserDB getUserDB() {
        return new UserRedis();
    }

    @Override
    public DepartmentDB getDepartmentDB() {
        return null;
    }
}
