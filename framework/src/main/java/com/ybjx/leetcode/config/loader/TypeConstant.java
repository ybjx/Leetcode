package com.ybjx.leetcode.config.loader;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据加载使用到的常量
 * @author ybjx
 * @date 2019/3/18 22:37
 */
public class TypeConstant {
    /**
     * int类型
     */
    public final static String INT = "int";

    /**
     * 浮点类型
     */
    public final static String FLOAT = "float";

    /**
     * 双精度类型
     */
    public final static String DOUBLE = "double";

    /**
     * 长整形
     */
    public final static String LONG = "long";

    /**
     * 布尔类型
     */
    public final static String BOOLEAN = "boolean";

    /**
     * 字符串类型
     */
    public final static String STRING = "string";

    /**
     * 字符类型
     */
    public final static String CHAR = "char";

    /**
     * void类型
     */
    public final static String VOID = "void";

    /**
     * 数组类型
     */
    public final static String ARRAY = "array";

    /**
     * 列表类型
     */
    public final static String LIST = "list";

    /**
     * 链表
     */
    public final static String LIST_NODE = "list-node";

    /**
     * 二叉树
     */
    public final static String TREE_NODE = "tree-node";

    /**
     * 带next节点的二叉树
     */
    public final static String NODE = "node";

    /**
     * 具有个别节点的无向图
     */
    public final static String NODE2 = "node2";

    /**
     * 对象类型
     */
    public final static String OBJECT = "object";

    /**
     * json文件中数据类型字段名称
     */
    public final static String JSON_FIELD_TYPE = "type";

    /**
     * json文件中数据的字段名称
     */
    public final static String JSON_FIELD_DATA = "data";

    /**
     * json文件中的返回值字段名称
     */
    public final static String JSON_FIELD_RESULT = "result";

    /**
     * json文件中的参数字段名称
     */
    public final static String JSON_FIELD_PARAM = "param";

    /**
     * json文件中的参数结果字段名称
     */
    public final static String JSON_FIELD_PARAM_RESULT = "param-result";

    /**
     * 参数返回值的位置
     */
    public final static String JSON_FIELD_PARAM_RESULT_INDEX = "param-result-index";

    /**
     * 默认类型对应的class映射
     */
    final static Map<String, Class> CLASS_MAP = new HashMap<String, Class>();

    static{
        CLASS_MAP.put(INT, int.class);
        CLASS_MAP.put(INT.toUpperCase(), Integer.class);
        CLASS_MAP.put(FLOAT, float.class);
        CLASS_MAP.put(FLOAT.toUpperCase(), Float.class);
        CLASS_MAP.put(LONG, long.class);
        CLASS_MAP.put(LONG.toUpperCase(), Long.class);
        CLASS_MAP.put(DOUBLE, double.class);
        CLASS_MAP.put(DOUBLE.toUpperCase(), Double.class);
        CLASS_MAP.put(BOOLEAN, boolean.class);
        CLASS_MAP.put(BOOLEAN.toUpperCase(), Boolean.class);
        CLASS_MAP.put(CHAR, char.class);
        CLASS_MAP.put(CHAR.toUpperCase(), Character.class);
        CLASS_MAP.put(STRING, String.class);
    }
}
