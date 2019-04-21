package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 * 题目：
 *     将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *     输入：1->2->4, 1->3->4
 *     输出：1->1->2->3->4->4
 * @author ybjx
 * @date 2019/4/21 11:11
 */
public class L021MergeTwoLists extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution1(ListNode l1, ListNode l2){
        ListNode root = null, p = null;
        if(l1 == null && l2 == null){
            return null;
        }
        else if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        while(l1 != null && l2 != null){
            if(root == null){
                root = new ListNode(l1.val > l2.val ? l2.val : l1.val);
                p = root;
            }
            else{
                p.next = new ListNode(l1.val > l2.val ? l2.val : l1.val);
                p = p.next;
            }
            if(l1.val > l2.val){
                l2 = l2.next;
            }
            else{
                l1 = l1.next;
            }
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return root;
    }

    @LeetCodeSolution
    public ListNode solution2(ListNode l1, ListNode l2){
        ListNode node = new ListNode(0);
        ListNode current = node;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null){
            current.next = l1;
        }
        if(l2 != null){
            current.next = l2;
        }
        return node.next;
    }

    @LeetCodeSolution
    public ListNode solution3(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = solution3(l1.next, l2);
            return l1;
        }
        else{
            l2.next = solution3(l1, l2.next);
            return l2;
        }
    }
}
