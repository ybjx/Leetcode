package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/partition-list/
 * 题目：
 *     给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *     你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *     输入: head = 1->4->3->2->5->2, x = 3
 *     输出: 1->2->2->4->3->5
 */
public class L086Partition extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head, int x){
        ListNode small = null;
        ListNode smallHead = null;
        ListNode big = null;
        ListNode bigHead = null;
        while (head != null){
            if(head.val < x){
                if(smallHead == null){
                    smallHead = head;
                    small = smallHead;
                }
                else{
                    small.next = head;
                    small = small.next;
                }
            }
            else{
                if(bigHead == null){
                    bigHead = head;
                    big = head;
                }
                else{
                    big.next = head;
                    big = big.next;
                }
            }
            head = head.next;
            if(small != null){
                small.next = null;
            }
            if(big != null){
                big.next = null;
            }
        }
        if(bigHead != null){
            if(smallHead == null){
                smallHead = bigHead;
            }
            else{
                small.next = bigHead;
            }
        }
        return smallHead;
    }
}
