package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 题目：
 *     编写一个程序，找到两个单链表相交的起始节点。
 */
public class L160GetIntersectionNode extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode headA, ListNode headB){
        ListNode p = headA;
        int a = 0;
        while (p != null){
            p = p.next;
            a++;
        }
        int b = 0;
        p = headB;
        while (p != null){
            p = p.next;
            b++;
        }
        int k = a - b;
        ListNode q;
        if(k >= 0){
            p = headA;
            q = headB;
        }
        else{
            p = headB;
            q = headA;
            k = -k;
        }
        while (k > 0){
            p = p.next;
            k--;
        }
        while (p != null){
            if(p == q){
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
