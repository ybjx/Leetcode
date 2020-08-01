package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/symmetric-tree/
 * 题目：
 *     给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *        1
 *       / \
 *      2   2
 *     / \ / \
 *    3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *        1
 *       / \
 *      2   2
 *      \   \
 *      3    3
 */
public class L101IsSymmetric extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(TreeNode root){
        if(root == null){
            return true;
        }
        update(root.right);
        return equal(root.left, root.right);
    }

    private void update(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        update(node.left);
        update(node.right);
    }

    private boolean equal(TreeNode p, TreeNode q){
        return p == null && q == null || p != null && q != null && p.val == q.val && equal(p.left, q.left) && equal(p.right, q.right);
    }
}
