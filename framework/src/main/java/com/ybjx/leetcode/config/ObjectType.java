package com.ybjx.leetcode.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据类型描述
 * @author ybjx
 * @date 2019/3/18 23:31
 */
public class ObjectType {

    /**
     * 参数类型
     */
    private List<String> params = new ArrayList<String>();

    /**
     * 返回值的数据类型
     */
    private String result;

    /**
     * 参数返回值的索引
     */
    private List<Integer> paramResultIndex = new ArrayList<Integer>();

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Integer> getParamResultIndex() {
        return paramResultIndex;
    }

    public void setParamResultIndex(List<Integer> paramResultIndex) {
        this.paramResultIndex = paramResultIndex;
    }

    @Override
    public String toString() {
        return "ObjectType{" +
                "params=" + params +
                ", result='" + result + '\'' +
                ", paramResultIndex=" + paramResultIndex +
                '}';
    }
}
