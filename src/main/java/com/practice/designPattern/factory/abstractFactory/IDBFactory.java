package com.practice.designPattern.factory.abstractFactory;

/**
 * @author zhaoxu
 * @className IDBFactory
 * @projectName JavaConcentration

 * @date 2/17/2020 10:25 PM
 */
interface IDBFactory {

    //change to factory method
    UserDB getUserDB();


    DepartmentDB getDepartmentDB();
}
