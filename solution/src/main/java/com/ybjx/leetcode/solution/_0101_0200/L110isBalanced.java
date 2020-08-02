package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/balanced-binary-tree/
 * 题目：
 *     给定一个二叉树，判断它是否是高度平衡的二叉树。
 *     本题中，一棵高度平衡二叉树定义为：
 *     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *     给定二叉树 [3,9,20,null,null,15,7]
 *         3
 *        / \
 *       9  20
 *         /  \
 *        15   7
 *     返回 true 。
 *
 * 示例 2:
 *     给定二叉树 [1,2,2,3,3,null,null,4,4]
 *            1
 *           / \
 *          2   2
 *         / \
 *        3   3
 *       / \
 *      4   4
 *     返回 false 。
 */
public class L110isBalanced extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(TreeNode root){
        return check(root)[0] == 1;
    }

    private int[] check(TreeNode root){
        int[] result = new int[2];
        result[0] = 1;
        if(root == null){
            return result;
        }
        int[] left = check(root.left);
        int[] right = check(root.right);
        if(left[0] == 0 || right[0] == 0){
            result[0] = 0;
            return result;
        }
        if(left[1] - right[1] > 1 || right[1] - left[1] > 1){
            result[0] = 0;
            return result;
        }
        result[1] = 1 + (left[1] > right[1] ? left[1] : right[1]);
        return result;
    }
}
