package com.practice.JavaBasicFeatures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaoxu
 * @className JavaAnnotation
 * @projectName JavaConcentration

 * @date 3/26/2020 10:03 AM
 */
//@Target表明作用目标
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.METHOD})
//@表明生命周期
@Retention(RetentionPolicy.RUNTIME)


//@interface定义注解类型
public @interface JavaAnnotation {
    String myName();

}
