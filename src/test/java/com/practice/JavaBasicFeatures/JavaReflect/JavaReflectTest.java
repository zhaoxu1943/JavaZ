package com.practice.JavaBasicFeatures.JavaReflect;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhaoxu
 * @className JavaReflectTest
 * @projectName JavaConcentration

 * @date 3/12/2020 9:09 PM
 */
public class JavaReflectTest {

    @Test
    public void getClazz() {
    }

    @Test
    public void getClazzFields() {
        try {
            JavaReflect.getClazzFields();
    } catch (Exception e) {
            e.printStackTrace();
        }
    }



}