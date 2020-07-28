package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 题目：
 *     给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *     输入: 1->1->2
 *     输出: 1->2
 *
 * 示例 2:
 *     输入: 1->1->2->3->3
 *     输出: 1->2->3
 */
public class L083DeleteDuplicates extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head){
        ListNode p = head;
        while (p != null && p.next != null){
            if(p.next.val == p.val){
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }
        }

        return head;
    }
}
