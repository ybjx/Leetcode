package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/sort-list/
 * 题目：
 *     在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *     输入: 4->2->1->3
 *     输出: 1->2->3->4
 *
 * 示例 2:
 *     输入: -1->5->3->4->0
 *     输出: -1->0->3->4->5
 */
public class L148SortList extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode last = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            last = slow;
            slow = slow.next;
        }
        last.next = null;
        ListNode left = solution(head);
        ListNode right = solution(slow);
        ListNode r = null;
        last = null;
        while (left != null || right != null){
            if(left == null){
                if(last == null){
                    r = right;
                }
                else{
                    last.next = right;
                }
                break;
            }
            if(right == null){
                if(last == null){
                    r = left;
                }
                else{
                    last.next = left;
                }
                break;
            }
            if(left.val < right.val){
                if(last == null){
                    r = left;
                    last = left;
                }
                else{
                    last.next = left;
                    last = last.next;
                }
                left = left.next;
                last.next = null;
            }
            else{
                if(last == null){
                    r = right;
                    last = right;
                }
                else{
                    last.next = right;
                    last = last.next;
                }
                right = right.next;
                last.next = null;
            }
        }
        return r;
    }
}
