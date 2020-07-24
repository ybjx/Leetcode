package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/rotate-list/
 * 题目：
 *     给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *     输入: 1->2->3->4->5->NULL, k = 2
 *     输出: 4->5->1->2->3->NULL
 *     解释:
 *       向右旋转 1 步: 5->1->2->3->4->NULL
 *       向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 *     输入: 0->1->2->NULL, k = 4
 *     输出: 2->0->1->NULL
 *     解释:
 *       向右旋转 1 步: 2->0->1->NULL
 *       向右旋转 2 步: 1->2->0->NULL
 *       向右旋转 3 步: 0->1->2->NULL
 *       向右旋转 4 步: 2->0->1->NULL
 */
public class L061RotateRight extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head , int k){
        if(head == null){
            return null;
        }
        int c = 0;
        ListNode p = head;
        ListNode last = null;

        while (p != null){
            c++;
            last = p;
            p = p.next;
        }

        k = c - k % c;
        p = head;
        while (p != null){
            k--;
            if(k == 0){
                break;
            }
            p = p.next;
        }
        if(p == null){
            return head;
        }
        else {
            last.next = head;
            last = p;
            p = p.next;
            last.next = null;
            return p;
        }
    }
}
