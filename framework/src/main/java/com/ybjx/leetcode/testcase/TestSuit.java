package com.ybjx.leetcode.testcase;

import com.ybjx.leetcode.config.ObjectType;
import com.ybjx.leetcode.config.ResourceLoader;

import java.util.List;

/**
 * 测试组
 * @author ybjx
 * @date 2019/3/18 23:30
 */
public class TestSuit {

    /**
     * 测试用例列表
     */
    private List<TestCase> testCases;

    /**
     * 参数类型
     */
    private ObjectType objectType;

    /**
     * 资源加载器
     */
    private ResourceLoader loader = new ResourceLoader();

    /**
     * 测试用例加载
     * @param configPaths 测试用例配置文件路径
     */
    public void load(List<String> configPaths){
        loader.clean();
        for(String str: configPaths){
            loader.addFile(str);
        }
        objectType = loader.loadObjectType();
        testCases = loader.load(objectType);
    }

    /**
     * 重写加载参数数据
     * @param testCase 测试用例
     */
    public void reloadTestCase(TestCase testCase){
        loader.loadTestCaseParam(testCase.getData(), testCase, objectType);
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public String toString() {
        return "TestSuit{" +
                "testCases=" + testCases +
                ", objectType=" + objectType +
                ", loader=" + loader +
                '}';
    }
}
