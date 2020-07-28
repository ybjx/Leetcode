package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 题目：
 *     给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *     输入: 1->2->3->3->4->4->5
 *     输出: 1->2->5
 *
 * 示例 2:
 *     输入: 1->1->1->2->3
 *     输出: 2->3
 */
public class L082DeleteDuplicates extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head){
        ListNode p = null;
        ListNode pre = null;
        ListNode ppre = null;
        ListNode current = head;
        int c = 0;
        while (current != null){
            if(pre != null){
                if(pre.val != current.val){
                    if(c == 0){
                        if(ppre == null){
                            ppre = pre;
                            p = ppre;
                        }
                        else{
                            ppre.next = pre;
                            ppre = ppre.next;
                        }
                    }
                    c = 0;
                }
                else{
                    c++;
                }
            }
            pre = current;
            current = current.next;
        }
        if(c == 0 && pre != null){
            if(ppre == null){
                p = pre;
                pre.next = null;
            }
            else{
                ppre.next = pre;
                pre.next = null;
            }
        }
        else{
            if(ppre != null) {
                ppre.next = null;
            }
        }
        return p;
    }
}
