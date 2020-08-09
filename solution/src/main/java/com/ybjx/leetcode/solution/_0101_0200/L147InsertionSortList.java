package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/insertion-sort-list/
 * 题目：
 *     对链表进行插入排序。
 *     插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 *     每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *     插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *     每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 *     重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *     输入: 4->2->1->3
 *     输出: 1->2->3->4
 *
 * 示例 2：
 *     输入: -1->5->3->4->0
 *     输出: -1->0->3->4->5
 */
public class L147InsertionSortList extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution(ListNode head){
        if(head == null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            ListNode n = p.next;
            if(list.size() > 0) {
                boolean find = false;
                for (int i = list.size() - 1; i >= 0; i--) {
                    ListNode t = list.get(i);
                    if (t.val < p.val) {
                        p.next = t.next;
                        t.next = p;
                        list.add(i + 1, p);
                        find = true;
                        break;
                    }
                }
                if(!find){
                    p.next = list.get(0);
                    list.add(0, p);
                }
            }
            else{
                p.next = null;
                list.add(p);
            }
            p = n;
        }
        return list.get(0);
    }
}
