package com.ybjx.leetcode.config.loader;

import com.alibaba.fastjson.JSONObject;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * Object数据类型的加载器
 * @author ybjx
 * @date 2019/3/18 23:02
 */
public class ObjectLoader implements IObjectLoader {

    /**
     * 加载数据
     * @param json 待加载的数据
     * @param type 数据类型
     * @return 解析后的数据
     */
    public Object load(Object json, String type) {
        if(!(json instanceof JSONObject)){
            throw new LeetCodeException("Object加载器只能解析JSONObject数据！");
        }
        Class clazz = getTypeClass(type);
        JSONObject obj = (JSONObject)json;
        return obj.toJavaObject(clazz);
    }

    /**
     * 获取数据类型对应的class
     * @param type 数据类型
     * @return 对应的class
     */
    public Class getTypeClass(String type) {
        try{
            return Class.forName(type);
        }
        catch (Exception e){
            throw new LeetCodeException("数据类型类[" + type + "]没有找到", e);
        }
    }
}
