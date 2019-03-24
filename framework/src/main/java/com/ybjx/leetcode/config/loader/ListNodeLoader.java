package com.ybjx.leetcode.config.loader;

import com.alibaba.fastjson.JSONArray;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.type.ListNode;

/**
 * @author ybjx
 * @date 2019/3/18 23:06
 */
public class ListNodeLoader implements IObjectLoader {

    /**
     * 加载数据
     * @param json 待加载的数据
     * @param type 数据类型
     * @return 解析后的数据
     */
    public Object load(Object json, String type) {
        if(!(json instanceof JSONArray)){
            throw new LeetCodeException("ListNode加载器只能加载JSONArray的数据！");
        }
        JSONArray array = (JSONArray)json;
        if(array.size() == 0){
            return null;
        }

        ListNode header = new ListNode(array.getInteger(0));
        ListNode p = header;
        for(int i = 1; i < array.size(); i++){
            ListNode temp = new ListNode(array.getInteger(i));
            p.next = temp;
            p = temp;
        }
        return header;
    }

    /**
     * 获取数据类型对应的class
     * @param type 数据类型
     * @return 对应的class
     */
    public Class getTypeClass(String type) {
        return ListNode.class;
    }
}
