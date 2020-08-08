package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.Node2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 题目地址：https://leetcode-cn.com/problems/clone-graph/
 * 题目：
 *     给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 示例
 *     输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 *     输出：[[2,4],[1,3],[2,4],[1,3]]
 *     解释：
 *       图中有 4 个节点。
 *       节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 *       节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 *       节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 *       节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 */
public class L133CloneGraph extends AbstractSolution {

    @LeetCodeSolution
    public Node2 solution(Node2 node){
        if(node == null){
            return null;
        }
        Map<Integer, Node2> map = new HashMap<>();
        Map<Integer, Node2> cache = new HashMap<>();
        Stack<Node2> stack = new Stack<>();
        stack.add(node);
        while (stack.size() > 0){
            Node2 n = stack.pop();
            if(!map.containsKey(n.val)){
                Node2 node2 = new Node2();
                node2.val = n.val;
                node2.neighbors = new ArrayList<>();
                map.put(node2.val, node2);
                cache.put(n.val, n);
                stack.addAll(n.neighbors);
            }
        }

        for(Node2 n: map.values()){
            Node2 node2 = cache.get(n.val);
            for(Node2 t: node2.neighbors){
                n.neighbors.add(map.get(t.val));
            }
        }
        return map.get(1);
    }
}
