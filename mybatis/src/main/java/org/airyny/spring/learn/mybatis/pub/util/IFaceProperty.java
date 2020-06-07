package org.airyny.spring.learn.mybatis.pub.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiang.yongye
 * @title: IFaceProperty
 * @description: TODO
 * @date 2020/3/13  13:14
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IFaceProperty {
    /**
     * 对应临时表的字段
     *
     * @return
     */
    String desc();

    /**
     * 是否必输
     *
     * @return
     */
    boolean required() default false;

}
