package com.ybjx.leetcode.solution._0201_0300;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 题目：
 *     删除链表中等于给定值 val 的所有节点。
 * 示例:
 *     输入: 1->2->6->3->4->5->6, val = 6
 *     输出: 1->2->3->4->5
 */
public class L203RemoveElements extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head, int val){
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;
        while (head != null){
            if(head.val == val){
                p.next = head.next;
            }
            else {
                p = head;
            }
            head = head.next;
        }
        return h.next;
    }
}
