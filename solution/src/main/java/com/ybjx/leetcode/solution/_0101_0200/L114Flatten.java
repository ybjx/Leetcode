package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 题目：
 *     给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *           1
 *          / \
 *         2   5
 *        / \   \
 *       3   4   6
 *     将其展开为：
 *         1
 *          \
 *           2
 *            \
 *             3
 *              \
 *               4
 *                \
 *                 5
 *                  \
 *                   6
 */
public class L114Flatten extends AbstractSolution {
    @JudgeMethod
    public void check(TreeNode param, TreeNode result){
        if(!param.equals(result)){
            throw new LeetCodeException("结果校验不通过");
        }
    }

    @LeetCodeSolution
    public void solution(TreeNode root){
        calc(root);
    }

    private TreeNode calc(TreeNode node){
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            return node;
        }

        TreeNode left = calc(node.left);
        TreeNode right = calc(node.right);
        if(left != null){
            left.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return right == null ? left : right;
    }
}
