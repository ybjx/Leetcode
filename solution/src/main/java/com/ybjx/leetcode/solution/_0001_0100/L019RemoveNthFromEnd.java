package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
 * 题目：
 *     给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *     给定一个链表: 1->2->3->4->5, 和 n = 2.
 *     当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *     给定的 n 保证是有效的。
 *
 * 进阶：
 *     你能尝试使用一趟扫描实现吗？
 * @author ybjx
 * @date 2019/4/21 10:40
 */
public class L019RemoveNthFromEnd extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head, int n){
        ListNode temp = null;
        ListNode current = head;

        while(current != null){
            if(temp != null){
                temp = temp.next;
            }
            if(n == 0) {
                temp = head;
            }
            n--;
            current = current.next;
        }
        if(temp != null){
            if(temp.next != null){
                temp.next = temp.next.next;
            }
        }
        else{
            return head.next;
        }
        return head;
    }
}
