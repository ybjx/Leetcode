package com.ybjx.leetcode.common;

/**
 * leetcode中的自定义异常类
 * @author ybjx
 * @date 2019/3/18 22:37
 */
public class LeetCodeException extends RuntimeException {
    /**
     * 带一个错误信息的构造方法
     * @param msg 错误信息
     */
    public LeetCodeException(String msg){
        super(msg);
    }

    /**
     * 带错误信息也异常的构造方法
     * @param msg 错误信息
     * @param e 上一个异常信息
     */
    public LeetCodeException(String msg, Exception e){
        super(msg, e);
    }
}
