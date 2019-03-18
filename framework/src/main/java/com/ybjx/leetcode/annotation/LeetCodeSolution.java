package com.ybjx.leetcode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * leetcode算法注解
 * @author ybjx
 * @date 2019/3/18 22:37
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LeetCodeSolution {

    /**
     * 算法的名称
     */
    String name() default "";
}
