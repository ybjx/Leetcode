package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 题目：
 *     给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *     例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *     计算从根到叶子节点生成的所有数字之和。
 *     说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *     输入: [1,2,3]
 *         1
 *        / \
 *       2   3
 *     输出: 25
 *     解释:
 *     从根到叶子节点路径 1->2 代表数字 12.
 *     从根到叶子节点路径 1->3 代表数字 13.
 *     因此，数字总和 = 12 + 13 = 25.
 *
 * 示例 2:
 *     输入: [4,9,0,5,1]
 *          4
 *         / \
 *        9   0
 *       / \
 *      5   1
 *     输出: 1026
 *     解释:
 *     从根到叶子节点路径 4->9->5 代表数字 495.
 *     从根到叶子节点路径 4->9->1 代表数字 491.
 *     从根到叶子节点路径 4->0 代表数字 40.
 *     因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class L129SumNumbers extends AbstractSolution {

    @LeetCodeSolution
    public int solution(TreeNode root){
        if(root == null){
            return 0;
        }
        return calc(root)[0];
    }

    private int[] calc(TreeNode node){
        int [] r = new int[2];
        if(node.left == null && node.right == null){
            r[0] = node.val;
            r[1] = 1;
            return r;
        }

        if(node.left != null){
            int[] left = calc(node.left);
            r[0] = node.val * left[1] * 10 + left[0];
            r[1] = left[1] * 10;
        }
        if(node.right != null){
            int[] right = calc(node.right);
            r[0] += (node.val * right[1] * 10 + right[0]);
            r[1] += right[1] * 10;
        }
        return r;
    }
}
