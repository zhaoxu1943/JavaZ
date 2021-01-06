package com.practice.JavaException;

import com.concentration.entity.UserInfo;

/**
 * @author zhaoxu
 * @className JavaRuntimeException
 * @projectName JavaConcentration
 * @date 2020/7/24 8:59
 */
public class JavaRuntimeException {


    public static void main(String[] args) {

        System.out.println(processMethod(3,2));


        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("wdnmd!");

        System.out.println(processMethod(userInfo));
    }


    /**
     * 比较年龄大小IllegalArgumentException
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static String processMethod(int i,int j){
        if (i<0 || j<0) {
            throw new IllegalArgumentException("年龄不能为负数");
        }else{
            return i<j?"第一个年龄小于第二个":"第一个年龄大于第二个";
        }

    }


    /**
     * 对象IllegalStateException
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static String processMethod(UserInfo userInfo){
        if (userInfo==null) {
            throw new IllegalStateException("对象为null,未被初始化");
        }else{
            return userInfo.getUserName();
        }

    }

}
