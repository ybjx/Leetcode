package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 题目：
 *     给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *     输入: [1,null,2,3]
 *       1
 *        \
 *        2
 *       /
 *      3
 *     输出: [1,3,2]
 */
public class L094InorderTraversal extends AbstractSolution {

    @LeetCodeSolution
    public List<Integer> solution(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(root.left != null){
            result.addAll(solution(root.left));
        }
        result.add(root.val);
        if(root.right != null){
            result.addAll(solution(root.right));
        }
        return result;
    }
}
