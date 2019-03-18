package com.ybjx.leetcode.testcase;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试用例
 * @author ybjx
 * @date 2019/3/18 23:26
 */
public class TestCase {

    /**
     * 测试用例名称
     */
    private String name;

    /**
     * 测试用例需要执行的次数
     */
    private Integer times;

    /**
     * 执行算法时的入参，执行被算法修改
     */
    private List<Object> params = new ArrayList<Object>();

    /**
     * 参数，不会变化的
     */
    private List<Object> paramsFixed = new ArrayList<Object>();

    /**
     * 执行返回值
     */
    private List<Object> result = new ArrayList<Object>();

    /**
     * 执行完以后入参的值
     */
    private List<Object> resultParam = new ArrayList<Object>();

    /**
     * 原始数据
     */
    private JSONObject data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }

    public List<Object> getParamsFixed() {
        return paramsFixed;
    }

    public void setParamsFixed(List<Object> paramsFixed) {
        this.paramsFixed = paramsFixed;
    }

    public List<Object> getResult() {
        return result;
    }

    public void setResult(List<Object> result) {
        this.result = result;
    }

    public List<Object> getResultParam() {
        return resultParam;
    }

    public void setResultParam(List<Object> resultParam) {
        this.resultParam = resultParam;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "name='" + name + '\'' +
                ", times=" + times +
                ", params=" + params +
                ", paramsFixed=" + paramsFixed +
                ", result=" + result +
                ", resultParam=" + resultParam +
                ", data=" + data +
                '}';
    }
}
