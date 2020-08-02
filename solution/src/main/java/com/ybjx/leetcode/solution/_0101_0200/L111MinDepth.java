package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 题目：
 *     给定一个二叉树，找出其最小深度。
 *     最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *     说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *     给定二叉树 [3,9,20,null,null,15,7],
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 *     返回它的最小深度  2.
 */
public class L111MinDepth extends AbstractSolution {

    @LeetCodeSolution
    public int solution(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = solution(root.left);
        int right = solution(root.right);
        if(left == 0){
            return 1 + right;
        }
        if(right == 0){
            return 1 + left;
        }
        return 1 + (left > right ? right : left);
    }
}
