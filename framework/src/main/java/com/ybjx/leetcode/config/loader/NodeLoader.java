package com.ybjx.leetcode.config.loader;

import com.alibaba.fastjson.JSONObject;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.type.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * node类型的加载器
 */
public class NodeLoader implements IObjectLoader {
    /**
     * 数据加载
     * @param json 待加载的数据
     * @param type 数据类型
     * @return Node类型的数据
     */
    public Object load(Object json, String type) {
        if(!(json instanceof JSONObject)){
            throw new LeetCodeException("Node加载器只能加载JSONObject的数据");
        }
        JSONObject jsonObject = (JSONObject)json;
        Map<String, Node> map = new HashMap<String, Node>();
        return load(jsonObject, map);
    }

    /**
     * 迭代加载
     * @param json 待加载的数据
     * @param map 引用池
     * @return Node数据
     */
    private Node load(JSONObject json, Map<String, Node> map){
        if(json == null){
            return null;
        }
        String ref = json.getString("$ref");
        if(ref != null && ref.length() > 0){
            return map.get(ref);
        }
        String id = json.getString("$id");
        Node node = new Node();
        node.val = json.getInteger("val");
        if(id != null && id.length() > 0){
            map.put(id, node);
        }
        node.left = load(json.getJSONObject("left"), map);
        node.next = load(json.getJSONObject("next"), map);
        node.right = load(json.getJSONObject("right"), map);
        return node;
    }

    public Class getTypeClass(String type) {
        return Node.class;
    }
}
