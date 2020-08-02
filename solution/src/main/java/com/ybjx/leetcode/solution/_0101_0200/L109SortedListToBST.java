package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;
import com.ybjx.leetcode.type.TreeNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 题目：
 *     给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *     本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *     给定的有序链表： [-10, -3, 0, 5, 9],
 *     一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 */
public class L109SortedListToBST extends AbstractSolution {

    @LeetCodeSolution
    public TreeNode solution(ListNode head){
        if(head == null){
            return null;
        }
        ListNode mid = head;
        ListNode temp = head;
        ListNode p = null;
        int t = 0;
        while (head.next != null){
            t++;
            if(t % 2 == 0){
                p = mid;
                mid = mid.next;
            }
            head = head.next;
        }
        if((t + 1) % 2 == 0){
            p = mid;
            mid = mid.next;
        }
        TreeNode node = new TreeNode(mid.val);
        if(p != null) {
            p.next = null;
            node.left = solution(temp);
        }
        node.right = solution(mid.next);
        return node;
    }
}
