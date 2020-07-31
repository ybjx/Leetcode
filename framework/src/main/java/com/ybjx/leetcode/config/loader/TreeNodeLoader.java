package com.ybjx.leetcode.config.loader;

import com.alibaba.fastjson.JSONArray;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.type.ListNode;
import com.ybjx.leetcode.type.TreeNode;

public class TreeNodeLoader implements IObjectLoader {
    public Object load(Object json, String type) {
        if(!(json instanceof JSONArray)){
            throw new LeetCodeException("TreeNode加载器只能加载JSONArray的数据！");
        }
        JSONArray array = (JSONArray)json;
        if(array.size() == 0){
            return null;
        }

        TreeNode header = new TreeNode(array.getInteger(0));
        load(header, array, 1);
        return header;
    }

    private int load(TreeNode node, JSONArray array, int index){
        if(index >= array.size()){
            return index;
        }
        Object obj = array.get(index);
        if(obj != null){
            TreeNode left = new TreeNode(Integer.valueOf(obj.toString()));
            node.left = left;
            index = load(left, array, index + 1);
        }
        else{
            index ++;
        }
        if(index >= array.size()){
            return index;
        }
        obj = array.get(index);
        if(obj != null){
            TreeNode right = new TreeNode(Integer.valueOf(obj.toString()));
            node.right = right;
            index = load(right, array, index + 1);
        }
        else{
            return index + 1;
        }
        return index;
    }

    public Class getTypeClass(String type) {
        return TreeNode.class;
    }
}
