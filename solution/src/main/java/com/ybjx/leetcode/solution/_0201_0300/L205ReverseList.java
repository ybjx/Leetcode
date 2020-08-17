package com.ybjx.leetcode.solution._0201_0300;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/reverse-linked-list/
 * 题目：
 *     反转一个单链表。
 *
 * 示例:
 *     输入: 1->2->3->4->5->NULL
 *     输出: 5->4->3->2->1->NULL
 */
public class L205ReverseList extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head){
        ListNode n = null;
        while (head != null){
            ListNode t = head.next;
            head.next = n;
            n = head;
            head = t;
        }
        return n;
    }
}
