package com.ybjx.leetcode.config.loader;

import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 默认数据加载器
 * @author ybjx
 * @date 2019/3/18 22:37
 */
public class DefaultLoader implements IObjectLoader {

    /**
     * 加载数据
     * @param json 待加载的数据
     * @param type 数据类型
     * @return 解析后的数据
     */
    public Object load(Object json, String type) {
        try{
            if(TypeConstant.INT.equalsIgnoreCase(type)){
                return Integer.valueOf(json.toString());
            }
            else if(TypeConstant.LONG.equalsIgnoreCase(type)){
                return Long.valueOf(json.toString());
            }
            else if(TypeConstant.FLOAT.equalsIgnoreCase(type)){
                return Float.valueOf(json.toString());
            }
            else if(TypeConstant.DOUBLE.equalsIgnoreCase(type)){
                return Double.valueOf(json.toString());
            }
            else if(TypeConstant.BOOLEAN.equalsIgnoreCase(type)){
                return Boolean.valueOf(json.toString());
            }
            else if(TypeConstant.CHAR.equalsIgnoreCase(type)){
                return json.toString().charAt(0);
            }
            else if(TypeConstant.STRING.equalsIgnoreCase(type)){
                return json.toString();
            }
            else{
                return null;
            }
        } catch (Exception e){
            throw new LeetCodeException("默认数据加载器加载数据出错！", e);
        }
    }

    /**
     * 获取数据类型对应的class
     * @param type 数据类型
     * @return 对应的class
     */
    public Class getTypeClass(String type) {
        return TypeConstant.CLASS_MAP.get(type);
    }
}
