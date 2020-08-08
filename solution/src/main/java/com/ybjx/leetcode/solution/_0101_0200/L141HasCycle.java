package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/linked-list-cycle/
 * 题目：
 *     给定一个链表，判断链表中是否有环。
 *     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *     输入：head = [3,2,0,-4], pos = 1
 *     输出：true
 *     解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *     输入：head = [1,2], pos = 0
 *     输出：true
 *     解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *     输入：head = [1], pos = -1
 *     输出：false
 *     解释：链表中没有环。
 */
public class L141HasCycle extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(ListNode head){
        ListNode temp = new ListNode(0);
        ListNode p = head;
        while (p != null){
            if(p.next == temp){
                return true;
            }
            ListNode l = p.next;
            p.next = temp;
            p = l;
        }

        return false;
    }
}
