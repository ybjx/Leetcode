package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 题目：
 *     给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *     假设一个二叉搜索树具有如下特征：
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 *     输入:
 *         2
 *        / \
 *       1   3
 *     输出: true
 *
 * 示例 2:
 *     输入:
 *         5
 *        / \
 *       1   4
 *          / \
 *         3   6
 *     输出: false
 *     解释: 输入为: [5,1,4,null,null,3,6]。
 *          根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class L098IsValidBST extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int[] r = calc(root);
        return r[0] == 1;

    }

    private int[] calc(TreeNode root){
        int[] r = new int[3];
        r[0] = 1;
        r[1] = root.val;
        r[2] = root.val;
        int [] t;
        if(root.left != null){
            t = calc(root.left);
            if(t[0] == 0){
                r[0] = 0;
                return r;
            }
            if(t[2] >= root.val){
                r[0] = 0;
                return r;
            }
            r[1] = t[1];
        }
        if(root.right != null){
            t = calc(root.right);
            if(t[0] == 0){
                r[0] = 0;
                return r;
            }
            if(t[1] <= root.val){
                r[0] = 0;
                return r;
            }
            r[2] = t[2];
        }
        return r;
    }
}
