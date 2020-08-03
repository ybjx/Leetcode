package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 题目：
 *     给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 *     填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *     初始状态下，所有 next 指针都被设置为 NULL。
 */
public class L116Connect extends AbstractSolution {

    @LeetCodeSolution
    public Node solution(Node root){
        List<List<Node>> list = calc(root);
        for(List<Node> l: list){
            for(int i = 0; i < l.size() - 1; i++){
                l.get(i).next = l.get(i + 1);
            }
        }
        return root;
    }

    private List<List<Node>> calc(Node node){
        List<List<Node>> result = new ArrayList<>();
        if(node == null){
            return result;
        }
        List<Node> list = new ArrayList<>();
        list.add(node);
        result.add(list);
        List<List<Node>> left = calc(node.left);
        List<List<Node>> right = calc(node.right);
        for(int i = 0; i < left.size(); i++){
            left.get(i).addAll(right.get(i));
        }
        result.addAll(left);
        return result;
    }
}
