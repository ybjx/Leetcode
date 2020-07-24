package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 题目：
 *      给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *      k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 示例：
 *      给定这个链表：1->2->3->4->5
 *      当 k = 2 时，应当返回: 2->1->4->3->5
 *      当 k = 3 时，应当返回: 3->2->1->4->5
 * @author ybjx
 * @date 2019/5/25 10:55
 */
public class L025ReverseKGroup extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution1(ListNode head, int k){
        ListNode result = new ListNode(0);
        ListNode point = result;
        while(head != null){
            int m = k;
            ListNode start = head;
            ListNode s = start;
            while(head != null){
                m --;
                head = head.next;
                if(m == 0){
                    break;
                }
            }
            if(m > 0){
                point.next = s;
                break;
            }
            while(start != head){
                ListNode temp = start;
                start = start.next;
                temp.next = point.next;
                point.next = temp;
            }
            point = s;
        }
        return result.next;
    }

    @LeetCodeSolution
    public ListNode solution2(ListNode head, int k){
        int m = 0;
        ListNode point = head;
        while(point != null){
            m++;
            point = point.next;
        }
        ListNode result = new ListNode(0);
        point = result;
        int n = m / k;
        while(n > 0){
            n--;
            m = k;
            ListNode s = head;
            while(m > 0){
                m --;
                ListNode temp = head;
                head = head.next;
                temp.next = point.next;
                point.next = temp;
            }
            point = s;
        }
        point.next = head;
        return result.next;
    }
}
