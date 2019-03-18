package com.ybjx.leetcode.config.loader;

import com.alibaba.fastjson.JSONArray;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.config.LoaderManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表数据加载器
 * @author ybjx
 * @date 2019/3/18 22:58
 */
public class ListLoader implements IObjectLoader {

    /**
     * 加载数据
     * @param json 待加载的数据
     * @param type 数据类型
     * @return 解析后的数据
     */
    public Object load(Object json, String type) {
        if(!(json instanceof JSONArray)){
            throw new LeetCodeException("列表加载器只能加载JSONArray类型的数据!");
        }
        JSONArray array = (JSONArray)json;

        List<Object> list = new ArrayList<Object>();
        for(Object o: array){
            list.add(LoaderManager.loadData(o, type));
        }
        return list;
    }

    /**
     * 获取数据类型对应的class
     * @param type 数据类型
     * @return 对应的class
     */
    public Class getTypeClass(String type) {
        return List.class;
    }
}
