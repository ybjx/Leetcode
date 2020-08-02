package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 题目：
 *     给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 *     给定二叉树 [3,9,20,null,null,15,7],
 *           3
 *          / \
 *         9  20
 *           /  \
 *          15   7
 *     返回其自底向上的层次遍历为：
 *       [
 *         [15,7],
 *         [9,20],
 *         [3]
 *       ]
 */
public class L107LevelOrderBottom extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> list = levelOrder(root);

        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> l: list){
            result.add(0, l);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<List<Integer>> left = levelOrder(root.left);
        List<List<Integer>> right = levelOrder(root.right);

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
