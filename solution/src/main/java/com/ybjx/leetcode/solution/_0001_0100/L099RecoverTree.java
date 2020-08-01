package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 题目：
 *     二叉搜索树中的两个节点被错误地交换。
 *     请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *     输入: [1,3,null,null,2]
 *        1
 *       /
 *      3
 *       \
 *        2
 *     输出: [3,1,null,null,2]
 *        3
 *       /
 *      1
 *       \
 *        2
 *
 * 示例 2:
 *     输入: [3,1,4,null,null,2]
 *        3
 *       / \
 *      1   4
 *         /
 *        2
 *     输出: [2,1,4,null,null,3]
 *       2
 *      / \
 *     1   4
 *        /
 *      3
 */
public class L099RecoverTree extends AbstractSolution {

    @JudgeMethod
    public void check(TreeNode result, TreeNode node){
        if(result == null || node == null || result.equals(node)){
            return;
        }
        throw new LeetCodeException("结果校验不通过");
    }

    @LeetCodeSolution
    public void solution(TreeNode root){
        if(root == null){
            return;
        }

        List<Integer> list = calc(root);
        list.sort(Comparator.naturalOrder());
        update(root, list, 0);
    }

    private List<Integer> calc(TreeNode node){
        List<Integer> list = new ArrayList<>();
        if(node.left != null){
            list.addAll(calc(node.left));
        }
        list.add(node.val);
        if(node.right != null){
            list.addAll(calc(node.right));
        }
        return list;
    }

    private int update(TreeNode node, List<Integer> list, int index){
        if(node.left != null){
            index = update(node.left, list, index);
        }
        node.val = list.get(index);
        index++;
        if(node.right != null){
            index = update(node.right, list, index);
        }
        return index;
    }
}
