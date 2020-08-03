package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.Node;

/**
 * 题目地址：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 题目：
 *     定一个二叉树
 *     填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *     初始状态下，所有 next 指针都被设置为 NULL。
 */
public class L117Connect extends AbstractSolution {

    @LeetCodeSolution
    public Node solution(Node root){
        calc(root);
        return root;
    }

    private void calc(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        Node p = root.right == null ? root.left:root.right;
        if(root.right != null && root.left != null){
            root.left.next = root.right;
        }
        Node n = root.next;
        while (n != null){
            if(n.left != null){
                p.next = n.left;
                break;
            }
            if(n.right != null){
                p.next = n.right;
                break;
            }
            n = n.next;
        }
        calc(root.right);
        calc(root.left);
    }
}
