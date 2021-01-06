package com.concentration.entity;

import java.util.Objects;

/**
 * @author zhaoxu
 * @className DepartmentInfo
 * @projectName JavaConcentration

 * @date 2/17/2020 11:14 PM
 */
public class DepartmentInfo {

    public String department_id;
    public String department_name;
    public String user_id;

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentInfo that = (DepartmentInfo) o;
        return department_id.equals(that.department_id) &&
                department_name.equals(that.department_name) &&
                user_id.equals(that.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department_id, department_name, user_id);
    }

    @Override
    public String toString() {
        return "DepartmentInfo{" +
                "department_id='" + department_id + '\'' +
                ", department_name='" + department_name + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
