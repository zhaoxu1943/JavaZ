package com.concentration.J2EE;

import java.io.Serializable;

/**
 * @author zhaoxu
 * @className JavaBean
 * @projectName JavaConcentration

 * @date 3/4/2020 11:02 PM
 * All properties private (use getters/setters)
 * A public no-argument constructor
 * Implements Serializable.
 *
 * a class is a JavaBean if it follows the standards.
 */
public class JavaBean  implements Serializable {

    private static final long serialVersionUID = 5097001666662208068L;

    private String userName;

    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
