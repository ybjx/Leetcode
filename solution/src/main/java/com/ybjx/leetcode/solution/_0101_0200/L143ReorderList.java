package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;
import com.ybjx.leetcode.type.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/reorder-list/
 * 题目：
 *     给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 *     将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *     给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 *     给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class L143ReorderList extends AbstractSolution {

    @JudgeMethod
    public void check(ListNode param, ListNode result){
        if(param == null){
            if(result == null){
                return;
            }
            else{
                throw new LeetCodeException("结果不正确");
            }
        }
        if(!param.equals(result)){
            throw new LeetCodeException("结果不正确");
        }
    }

    @LeetCodeSolution
    public void solution(ListNode head){
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            list.add(p);
            ListNode t = p.next;
            p.next = null;
            p = t;
        }
        int l = 1;
        int r = list.size() - 1;
        int k = 0;
        p = head;
        while (l <= r){
            if(k % 2 == 0){
                p.next = list.get(r);
                r--;
            }
            else{
                p.next = list.get(l);
                l++;
            }
            p = p.next;
            k++;
        }
    }
}
