package com.ybjx.leetcode.config.loader;

/**
 * 测试数据加载接口
 * create by YuBing at 2019/3/18
 */
public interface IObjectLoader {

    /**
     * 加载数据
     * @param json 待加载的数据
     * @param type 数据类型
     * @return 解析后的数据
     */
    Object load(Object json, String type);

    /**
     * 获取数据类型对应的class
     * @param type 数据类型
     * @return 对应的class
     */
    Class getTypeClass(String type);
}
