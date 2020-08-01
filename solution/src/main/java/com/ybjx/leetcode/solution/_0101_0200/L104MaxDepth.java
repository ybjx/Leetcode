package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 题目：
 *     给定一个二叉树，找出其最大深度。
 *     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *     说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 *     给定二叉树 [3,9,20,null,null,15,7]，
 *           3
 *          / \
 *         9  20
 *           /  \
 *          15   7
 *     返回它的最大深度 3 。
 */
public class L104MaxDepth extends AbstractSolution {

    @LeetCodeSolution
    public int solution(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = solution(root.left);
        int r = solution(root.right);

        return 1 + (l > r?l:r);
    }
}
