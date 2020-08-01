package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 题目：
 *     给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 *     二叉树：[3,9,20,null,null,15,7],
 *           3
 *          / \
 *         9  20
 *           /  \
 *         15   7
 *     返回其层次遍历结果：
 *     [
 *       [3],
 *       [9,20],
 *       [15,7]
 *     ]
 */
public class L102LevelOrder extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<List<Integer>> left = solution(root.left);
        List<List<Integer>> right = solution(root.right);

        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        list.add(temp);
        int t = 0;
        while(t < left.size() || t < right.size()){
            List<Integer> l;
            if(t < left.size()){
                l = left.get(t);
            }
            else{
                l = new ArrayList<>();
            }
            if(t < right.size()){
                l.addAll(right.get(t));
            }
            if(l.size() > 0){
                list.add(l);
            }
            t++;
        }
        return list;
    }
}
