package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 题目：
 *      给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例：
 *      给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @author ybjx
 * @date 2019/5/25 10:37
 */
public class L024SwapPairs extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head){
        ListNode result = new ListNode(0);
        ListNode point = result;
        ListNode first = null;
        ListNode second = null;

        while(head != null){
            if(first == null){
                first = head;
            }
            else{
                second = head;
            }
            head = head.next;
            if(second != null){
                point.next = second;
                second.next = first;
                first.next = null;
                point = first;
                first = null;
                second = null;
            }
            else{
                if(head == null){
                    point.next = first;
                }
            }
        }
        return result.next;
    }
}
