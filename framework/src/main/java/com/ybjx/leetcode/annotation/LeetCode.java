package com.ybjx.leetcode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * leetcode配置注解
 * @author ybjx
 * @date 2019/3/18 22:37
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LeetCode {

    /**
     * 测试用例文件地址
     */
    String[] dataUrl() default "";

    /**
     * 是否使用默认的测试数据
     */
    boolean useDefaultData() default true;
}
