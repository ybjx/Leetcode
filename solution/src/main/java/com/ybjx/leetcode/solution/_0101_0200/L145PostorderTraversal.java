package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 题目：
 *     给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *     输入: [1,null,2,3]
 *         1
 *          \
 *          2
 *         /
 *        3
 *     输出: [3,2,1]
 */
public class L145PostorderTraversal extends AbstractSolution {

    @LeetCodeSolution
    public List<Integer> solution(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.addAll(solution(root.left));
        list.addAll(solution(root.right));
        list.add(root.val);
        return list;
    }
}
