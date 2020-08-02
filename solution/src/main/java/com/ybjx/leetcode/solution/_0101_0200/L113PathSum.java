package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/path-sum-ii/
 * 题目：
 *     给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *     说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *     给定如下二叉树，以及目标和 sum = 22，
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 *     返回:
 *       [
 *         [5,4,11,2],
 *         [5,8,4,5]
 *       ]
 */
public class L113PathSum extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution(TreeNode root, int sum){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        if(root.left == null && root.right == null){
            if(root.val == sum){
                List<Integer> l = new ArrayList<>();
                l.add(root.val);
                list.add(l);
            }
            return list;
        }
        sum -= root.val;
        list.addAll(solution(root.left, sum));
        list.addAll(solution(root.right, sum));
        for(List<Integer> l: list){
            l.add(0, root.val);
        }
        return list;
    }
}
