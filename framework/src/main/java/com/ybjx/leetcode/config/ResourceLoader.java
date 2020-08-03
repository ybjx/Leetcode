package com.ybjx.leetcode.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.CharStreams;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.config.loader.TypeConstant;
import com.ybjx.leetcode.testcase.TestCase;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试用例数据加载类
 * @author ybjx
 * @date 2019/3/18 23:34
 */
public class ResourceLoader {

    /**
     * 加载得到的数据
     */
    private JSONObject data = new JSONObject();

    /**
     * 添加配置文件，并解析json
     * @param file 文件地址
     */
    public void addFile(String file){
        String result;
        try{
            InputStream inputStream = ResourceLoader.class.getResourceAsStream(file);
            result = CharStreams.toString(new InputStreamReader(inputStream, Charsets.UTF_8));
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
        Object json = JSON.parse(result, Feature.DisableCircularReferenceDetect);
        if(json instanceof JSONObject){
            JSONObject obj = (JSONObject)json;
            if(obj.getJSONObject(TypeConstant.JSON_FIELD_TYPE) != null){
                if(data.getJSONObject(TypeConstant.JSON_FIELD_TYPE) != null){
                    throw new LeetCodeException("数据类型配置只能有一份！");
                }
                data.put(TypeConstant.JSON_FIELD_TYPE, obj.getJSONObject(TypeConstant.JSON_FIELD_TYPE));
            }
            if(obj.getJSONArray(TypeConstant.JSON_FIELD_DATA) != null){
                appendData(obj.getJSONArray(TypeConstant.JSON_FIELD_DATA));
            }
        }
        else if(json instanceof JSONArray){
            appendData((JSONArray)json);
        }
        else{
            throw new LeetCodeException("测试用例数据格式错误！");
        }
    }

    /**
     * 加载全部的测试用例
     * @param type 数据类型
     * @return 所有的测试用例
     */
    public List<TestCase> load(ObjectType type){
        JSONArray array = data.getJSONArray(TypeConstant.JSON_FIELD_DATA);
        List<TestCase> result = new ArrayList<TestCase>();
        if(array == null || array.size() == 0){
            return result;
        }
        for(Object obj: array){
            result.add(loadTestCase(type, (JSONObject) obj));
        }

        return result;
    }

    /**
     * 加载测试用例的参数
     * @param obj 原始数据
     * @param testCase 测试用例
     * @param type 参数类型
     */
    public void loadTestCaseParam(JSONObject obj, TestCase testCase, ObjectType type){
        JSONArray array = obj.getJSONArray(TypeConstant.JSON_FIELD_PARAM);
        if(array == null){
            throw new LeetCodeException("没有配置参数信息");
        }
        if(array.size() != type.getParams().size()){
            throw new LeetCodeException("参数个数不匹配！");
        }
        testCase.getParams().clear();
        for(int i = 0; i < array.size(); i++){
            testCase.getParams().add(LoaderManager.loadData(array.get(i), type.getParams().get(i)));
        }
    }

    /**
     * 清空数据
     */
    public void clean(){
        this.data = new JSONObject();
    }

    /**
     * 加载参数配置
     * @return 参数配置
     */
    public ObjectType loadObjectType(){
        JSONObject obj = data.getJSONObject(TypeConstant.JSON_FIELD_TYPE);
        if(obj == null){
            throw new LeetCodeException("没有找到参数类型相关的配置！");
        }
        ObjectType type = new ObjectType();
        type.setResult(obj.getString(TypeConstant.JSON_FIELD_RESULT));
        type.setParams(obj.getJSONArray(TypeConstant.JSON_FIELD_PARAM).toJavaList(String.class));

        JSONArray array = obj.getJSONArray(TypeConstant.JSON_FIELD_PARAM_RESULT_INDEX);
        if(array != null){
            type.setParamResultIndex(array.toJavaList(Integer.class));
            for(int i = 0; i < type.getParamResultIndex().size(); i++){
                Integer index = type.getParamResultIndex().get(i);
                if(index == null || index < 0 || index >= type.getParams().size()){
                    throw new LeetCodeException("参数返回值索引范围不正确！");
                }
            }
        }
        return type;
    }

    /**
     * 加载单个测试用例
     * @param type 数据类型
     * @param obj 待加载的数据
     * @return 加载完成的测试用例
     */
    private TestCase loadTestCase(ObjectType type, JSONObject obj){
        TestCase testCase = new TestCase();
        String name = obj.getString("name");
        if(!Strings.isNullOrEmpty(name)){
            testCase.setName(name);
        }
        Integer times = obj.getInteger("times");
        if(times == null || times <= 0){
            times = 1;
        }
        testCase.setTimes(times);
        testCase.setData(obj);

        JSONArray array;
        if(!TypeConstant.VOID.equalsIgnoreCase(type.getResult())){
            array = obj.getJSONArray(TypeConstant.JSON_FIELD_RESULT);
            if(array == null){
                throw new LeetCodeException("没有配置返回值数据");
            }
            else{
                for(Object o: array){
                    Object res = LoaderManager.loadData(o, type.getResult());
                    testCase.getResult().add(res);
                }
                if(testCase.getResult().size() == 0){
                    throw new LeetCodeException("没有解析到任何返回值数据！");
                }
            }
        }
        this.loadTestCaseParam(obj, testCase, type);

        array = obj.getJSONArray(TypeConstant.JSON_FIELD_PARAM);
        for(int i = 0; i < array.size(); i++){
            testCase.getParamsFixed().add(LoaderManager.loadData(array.get(i), type.getParams().get(i)));
        }

        if(type.getParamResultIndex().size() > 0){
            array = obj.getJSONArray(TypeConstant.JSON_FIELD_PARAM_RESULT);
            if(array != null){
                if(array.size() != type.getParamResultIndex().size()){
                    throw new LeetCodeException("参数返回值个数不匹配！");
                }
                for(int i = 0; i < array.size(); i++){
                    int index = type.getParamResultIndex().get(i);
                    testCase.getResultParam().add(LoaderManager.loadData(array.get(i), type.getParams().get(index)));
                }
            }
            else{
                throw new LeetCodeException("参数返回值配置不正确！");
            }
        }
        if(testCase.getResultParam().size() == 0 && type.getResult().equalsIgnoreCase(TypeConstant.VOID)){
            throw new LeetCodeException("方法返回值和参数返回值至少需要配置一个！");
        }
        return testCase;
    }

    /**
     * 往用例数据中追加新的测试数据
     * @param array 新的测试用例数据
     */
    private void appendData(JSONArray array){
        JSONArray a = data.getJSONArray(TypeConstant.JSON_FIELD_DATA);
        if(a == null){
            a = new JSONArray();
            a.addAll(array);
            data.put(TypeConstant.JSON_FIELD_DATA, a);
        }
        else{
            a.addAll(array);
        }
    }
}
