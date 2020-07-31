package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 题目：
 *     反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *     说明:
 *         1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *     输入: 1->2->3->4->5->NULL, m = 2, n = 4
 *     输出: 1->4->3->2->5->NULL
 */
public class L092ReverseBetween extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head, int m, int n){
        ListNode first = new ListNode(0);
        ListNode p = first;
        ListNode l = first;
        first.next = head;
        int k = 0;
        while (head != null){
            if(k < m - 1){
                l = head;
                p = head;
                head = head.next;
            }
            else if(k == m - 1){
                l = head;
                head = head.next;
            }
            else if(k < n){
                l.next = head.next;
                head.next = p.next;
                p.next = head;
                head = l.next;
            }
            else{
                break;
            }
            k++;
        }
        return first.next;
    }
}
