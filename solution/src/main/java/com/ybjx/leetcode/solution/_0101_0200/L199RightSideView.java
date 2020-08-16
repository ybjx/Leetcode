package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 题目：
 *     给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *     输入: [1,2,3,null,5,null,4]
 *     输出: [1, 3, 4]
 *     解释:
 *          1            <---
 *        /   \
 *       2     3         <---
 *        \     \
 *         5     4       <---
 */
public class L199RightSideView extends AbstractSolution {

    @LeetCodeSolution
    public List<Integer> solution(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() > 0){
            result.add(list.get(list.size() - 1).val);

            List<TreeNode> temp = new ArrayList<>();
            for(TreeNode t: list){
                if(t.left != null){
                    temp.add(t.left);
                }
                if(t.right != null){
                    temp.add(t.right);
                }
            }
            list.clear();
            list.addAll(temp);
        }
        return result;
    }
}
