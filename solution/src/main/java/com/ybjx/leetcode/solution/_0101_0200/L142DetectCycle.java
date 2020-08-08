package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 题目：
 *     给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 示例 1：
 *     输入：head = [3,2,0,-4], pos = 1
 *     输出：tail connects to node index 1
 *     解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *     输入：head = [1,2], pos = 0
 *     输出：tail connects to node index 0
 *     解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *     输入：head = [1], pos = -1
 *     输出：no cycle
 *     解释：链表中没有环。
 */
public class L142DetectCycle extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head){
        ListNode n = hasCycle(head);
        if(n == null){
            return null;
        }
        ListNode r = head;
        while (r != n){
            r = r.next;
            n = n.next;
        }
        return r;
    }

    private ListNode hasCycle(ListNode node){
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return slow;
            }
        }
        return null;
    }
}
