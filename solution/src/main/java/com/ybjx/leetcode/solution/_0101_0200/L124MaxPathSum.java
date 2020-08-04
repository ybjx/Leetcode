package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 题目：
 *     给定一个非空二叉树，返回其最大路径和。
 *     本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *     输入: [1,2,3]
 *         1
 *        / \
 *       2   3
 *     输出: 6
 *
 * 示例 2:
 *     输入: [-10,9,20,null,null,15,7]
 *        -10
 *        / \
 *       9  20
 *         /  \
 *        15   7
 *     输出: 42
 */
public class L124MaxPathSum extends AbstractSolution {

    @LeetCodeSolution
    public int solution(TreeNode root){
        if(root == null){
            return 0;
        }
        return calc(root)[0];
    }

    private int[] calc(TreeNode node){
        int[] result = new int[2];
        int t = Integer.MIN_VALUE;
        int m = Integer.MIN_VALUE;
        result[0] = node.val;
        result[1] = node.val;
        if(node.left != null){
            int[] left = calc(node.left);
            t = left[0];
            m = left[1];
            if(left[1] > 0){
               result[0] += left[1];
            }
        }
        if(node.right != null){
            int[] right = calc(node.right);
            if(t < right[0]){
                t = right[0];
            }
            if(m < right[1]){
                m = right[1];
            }
            if(right[1] > 0){
                result[0] += right[1];
            }
        }
        result[0] = Math.max(result[0], t);
        if(m > 0) {
            result[1] = node.val + m;
        }
        return result;
    }
}
