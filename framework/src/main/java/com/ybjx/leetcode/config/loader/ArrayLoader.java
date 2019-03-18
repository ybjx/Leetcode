package com.ybjx.leetcode.config.loader;

import com.alibaba.fastjson.JSONArray;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.config.LoaderManager;

import java.lang.reflect.Array;

/**
 * @author ybjx
 * @date 2019/3/18 22:42
 */
public class ArrayLoader implements IObjectLoader {

    /**
     * 加载数据
     * @param json 待加载的数据
     * @param type 数据类型
     * @return 解析后的数据
     */
    public Object load(Object json, String type) {
        if(!(json instanceof JSONArray)){
            throw new LeetCodeException("ArrayLoader只能解析JSONArray格式的数据!");
        }

        JSONArray array = (JSONArray)json;

        Class clazz = LoaderManager.getTypeClass(type);
        Object a = Array.newInstance(clazz, array.size());

        for(int i = 0; i < array.size(); i++){
            Array.set(a, i, LoaderManager.loadData(array.get(i), type));
        }
        return a;
    }

    /**
     * 获取数据类型对应的class
     * @param type 数据类型
     * @return 对应的class
     */
    public Class getTypeClass(String type) {
        Class clazz = LoaderManager.getTypeClass(type);
        Object o = Array.newInstance(clazz, 1);
        return o.getClass();
    }
}
