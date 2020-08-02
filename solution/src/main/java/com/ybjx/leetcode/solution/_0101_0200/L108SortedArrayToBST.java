package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 题目：
 *     将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *     本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *     给定有序数组: [-10,-3,0,5,9],
 *     一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *          0
 *         / \
 *       -3   9
 *       /   /
 *     -10  5
 */
public class L108SortedArrayToBST extends AbstractSolution {

    @LeetCodeSolution
    public TreeNode solution(int [] nums){
        if(nums == null){
            return null;
        }
        return calc(nums, 0, nums.length);
    }

    public TreeNode calc(int[] nums, int s, int e){
        if(s >= e){
            return null;
        }
        int n = (s + e) / 2;
        TreeNode t = new TreeNode(nums[n]);
        t.left = calc(nums, s, n);
        t.right = calc(nums, n + 1, e);
        return t;
    }
}
