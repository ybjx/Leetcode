package com.ybjx.leetcode.config.loader;

import com.alibaba.fastjson.JSONArray;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.type.Node2;

import java.util.ArrayList;
import java.util.List;

public class Node2Loader implements IObjectLoader {
    public Object load(Object json, String type) {

        if(!(json instanceof JSONArray)){
            throw new LeetCodeException("Node2类型只能加载array类型");
        }

        JSONArray array = (JSONArray)json;
        if(array.size() == 0){
            return null;
        }
        List<Node2> list = new ArrayList<Node2>();

        for(int i = 0; i < array.size(); i++){
            Node2 n = new Node2();
            n.val = i + 1;
            n.neighbors = new ArrayList<Node2>();
            list.add(n);
        }
        for(int i = 0; i < array.size(); i++){
            Node2 n = list.get(i);
            JSONArray a = array.getJSONArray(i);
            for(int k = 0; k < a.size(); k++){
                n.neighbors.add(list.get(a.getInteger(k) - 1));
            }
        }

        return list.get(0);
    }

    public Class getTypeClass(String type) {
        return Node2.class;
    }
}
