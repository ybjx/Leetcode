package com.ybjx.leetcode.config.loader;

import com.alibaba.fastjson.JSONArray;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.type.Node2;
import com.ybjx.leetcode.type.Node3;

import java.util.ArrayList;
import java.util.List;

public class Node3Loader implements IObjectLoader {
    public Object load(Object json, String type) {

        if(!(json instanceof JSONArray)){
            throw new LeetCodeException("Node2类型只能加载array类型");
        }

        JSONArray array = (JSONArray)json;
        if(array.size() == 0){
            return null;
        }
        List<Node3> list = new ArrayList<Node3>();

        for(int i = 0; i < array.size(); i++){
            Node3 n = new Node3();
            list.add(n);
        }
        for(int i = 0; i < array.size(); i++){
            Node3 n = list.get(i);
            JSONArray a = array.getJSONArray(i);
            n.val = a.getInteger(0);
            if(a.size() > 1 && a.getInteger(1) != null){
                n.random = list.get(a.getInteger(1));
            }
            if(i < array.size() - 1){
                n.next = list.get(i + 1);
            }
        }

        return list.get(0);
    }

    public Class getTypeClass(String type) {
        return Node3.class;
    }
}
