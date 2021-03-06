package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 题目：
 *     根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 *     你可以假设树中没有重复的元素。
 * 例如，给出
 *     前序遍历 preorder = [3,9,20,15,7]
 *     中序遍历 inorder = [9,3,15,20,7]
 *     返回如下的二叉树：
 *         3
 *        / \
 *       9  20
 *         /  \
 *        15   7
 */
public class L105BuildTree extends AbstractSolution {

    @LeetCodeSolution
    public TreeNode solution(int[] preorder, int[] inorder){
        return calc( preorder, 0, inorder, 0, inorder.length);
    }

    public TreeNode calc(int[] preorder, int l1, int[] inorder, int l2, int r2){
        int index = -1;
        for(int i = l2; i < r2; i++){
            if(preorder[l1] == inorder[i]){
                index = i;
            }
        }
        if(index < 0){
            return null;
        }
        TreeNode node = new TreeNode(preorder[l1]);
        if(index > l2) {
            node.left = calc(preorder, l1 + 1, inorder, l2, index);
        }
        node.right = calc(preorder, l1 + index - l2 + 1, inorder, index + 1, r2);
        return node;
    }
}
