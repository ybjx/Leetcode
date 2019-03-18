package com.ybjx.leetcode.config.loader;

/**
 * create by YuBing at 2019/3/18
 */
public class DefaultLoader implements IObjectLoader {

    /**
     * 加载数据
     * @param json 待加载的数据
     * @param type 数据类型
     * @return 解析后的数据
     */
    public Object load(Object json, String type) {
        return null;
    }

    /**
     * 获取数据类型对应的class
     * @param type 数据类型
     * @return 对应的class
     */
    public Class getTypeClass(String type) {
        return null;
    }
}
