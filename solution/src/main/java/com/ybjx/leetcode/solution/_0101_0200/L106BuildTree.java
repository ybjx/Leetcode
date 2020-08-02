package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 题目：
 *     根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 *     你可以假设树中没有重复的元素。
 * 例如，给出
 *     中序遍历 inorder = [9,3,15,20,7]
 *     后序遍历 postorder = [9,15,7,20,3]
 *     返回如下的二叉树：
 *         3
 *        / \
 *       9  20
 *         /  \
 *        15   7
 */
public class L106BuildTree extends AbstractSolution {

    @LeetCodeSolution
    public TreeNode solution(int[] inorder, int[] postorder){
        return calc( postorder, postorder.length - 1, inorder, 0, inorder.length);
    }

    public TreeNode calc(int[] postorder, int l1, int[] inorder, int l2, int r2){
        int index = -1;
        for(int i = r2 - 1; i >= l2; i--){
            if(postorder[l1] == inorder[i]){
                index = i;
            }
        }
        if(index < 0){
            return null;
        }
        TreeNode node = new TreeNode(postorder[l1]);
        if(index < r2 - 1) {
            node.right = calc(postorder, l1 - 1, inorder, index + 1, r2);
        }
        node.left = calc(postorder, l1 - r2 + index, inorder, l2, index);
        return node;
    }
}
