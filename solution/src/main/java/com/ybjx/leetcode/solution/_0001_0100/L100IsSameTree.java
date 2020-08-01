package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/same-tree/
 * 题目：
 *     给定两个二叉树，编写一个函数来检验它们是否相同。
 *     如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *     输入:       1         1
 *               / \       / \
 *              2   3     2   3
 *             [1,2,3],   [1,2,3]
 *     输出: true
 *
 * 示例 2:
 *     输入:      1          1
 *               /           \
 *              2             2
 *            [1,2],     [1,null,2]
 *     输出: false
 *
 * 示例 3:
 *     输入:       1         1
 *               / \       / \
 *              2   1     1   2
 *             [1,2,1],   [1,1,2]
 *     输出: false
 */
public class L100IsSameTree extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(TreeNode p, TreeNode q) {
        return p == null && q == null || p != null && q != null && p.val == q.val && solution(p.left, q.left) && solution(p.right, q.right);
    }
}
