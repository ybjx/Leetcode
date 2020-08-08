package com.ybjx.leetcode.config.loader;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.type.ListNode;

/**
 * @author ybjx
 * @date 2019/3/18 23:06
 */
public class ListNode2Loader implements IObjectLoader {

    /**
     * 加载数据
     * @param json 待加载的数据
     * @param type 数据类型
     * @return 解析后的数据
     */
    public Object load(Object json, String type) {
        if(!(json instanceof JSONObject)){
            throw new LeetCodeException("ListNode2加载器只能加载JSONObject的数据！");
        }
        JSONObject obj = (JSONObject)json;

        JSONArray array = obj.getJSONArray("head");
        int pos = obj.getInteger("pos");

        ListNode header = new ListNode(array.getInteger(0));
        ListNode p = header;
        ListNode n = header;
        for(int i = 1; i < array.size(); i++){
            ListNode temp = new ListNode(array.getInteger(i));
            p.next = temp;
            p = temp;
            if(pos == i){
                n = temp;
            }
        }
        if(pos >= 0){
            p.next = n;
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
