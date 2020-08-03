package com.ybjx.leetcode.config;

import com.google.common.base.Strings;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.config.loader.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据加载管理类
 * @author ybjx
 * @date 2019/3/18 22:37
 */
public class LoaderManager {

    /**
     * 加载器映射表
     */
    private static Map<String, IObjectLoader> loaders = new ConcurrentHashMap<String, IObjectLoader>();

    static{
        loaders.put(TypeConstant.BOOLEAN, new DefaultLoader());
        loaders.put(TypeConstant.INT, new DefaultLoader());
        loaders.put(TypeConstant.FLOAT, new DefaultLoader());
        loaders.put(TypeConstant.DOUBLE, new DefaultLoader());
        loaders.put(TypeConstant.LONG, new DefaultLoader());
        loaders.put(TypeConstant.CHAR, new DefaultLoader());
        loaders.put(TypeConstant.VOID, new DefaultLoader());
        loaders.put(TypeConstant.STRING, new DefaultLoader());
        loaders.put(TypeConstant.ARRAY, new ArrayLoader());
        loaders.put(TypeConstant.LIST, new ListLoader());
        loaders.put(TypeConstant.OBJECT, new ObjectLoader());
        loaders.put(TypeConstant.LIST_NODE, new ListNodeLoader());
        loaders.put(TypeConstant.TREE_NODE, new TreeNodeLoader());
        loaders.put(TypeConstant.NODE, new NodeLoader());
    }

    /**
     * 加载数据
     * @param json 待加载的数据
     * @param type 数据类型
     * @return 解析出来的数据
     */
    public static Object loadData(Object json, String type){
        String[] types = getTypes(type);
        return getLoader(types[0]).load(json, types[1]);
    }

    /**
     * 获取数据类型对应的类
     * @param type 数据类型
     * @return 类名称
     */
    public static Class getTypeClass(String type){
        String[] types = getTypes(type);
        Class clazz = getLoader(types[0]).getTypeClass(types[1]);
        if(clazz == null){
            throw new LeetCodeException("数据类型对应的class没有找到！");
        }
        return clazz;
    }

    /**
     * 解析数据类型
     * @param type 数据类型，如："array:int"
     * @return 解析后的数据类型，解析后的结果：["array","int"]
     */
    private static String[] getTypes(String type){
        int index = type.indexOf(":");
        if(index == -1){
            return new String[] {type.toLowerCase(), type};
        }
        else{
            String t = type.substring(0, index);
            String p = type.substring(index + 1);
            if(Strings.isNullOrEmpty(t) || Strings.isNullOrEmpty(p)){
                throw new LeetCodeException("数据类型不能为空！");
            }
            return new String[]{t.toLowerCase(), p};
        }
    }

    /**
     * 获取数据加载器
     * @param type 数据类型
     * @return 数据加载器
     */
    private static IObjectLoader getLoader(String type){
        IObjectLoader loader = loaders.get(type);
        if(loader == null){
            throw new LeetCodeException("不支持的数据类型：" + type);
        }
        return loader;
    }
}
