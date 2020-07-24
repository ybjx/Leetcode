package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.ListNode;

/**
 * 题目地址：https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/
 * 题目：
 *     合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *     输入:
 *     [
 *       1->4->5,
 *       1->3->4,
 *       2->6
 *     ]
 *     输出: 1->1->2->3->4->4->5->6
 * @author ybjx
 * @date 2019/5/21 23:18
 */
public class L023MergeKLists extends AbstractSolution {

    @LeetCodeSolution
    public ListNode solution1(ListNode[] lists){
        ListNode result = null;
        ListNode pt = null;
        while(true){
            int p = -1;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] == null){
                    continue;
                }
                if(lists[i].val < min){
                    p = i;
                    min = lists[i].val;
                }
            }

            if(p == -1){
                break;
            }
            if(result == null){
                result = lists[p];
                pt = result;
            }
            else{
                pt.next = lists[p];
                pt = pt.next;
            }
            lists[p] = lists[p].next;
        }

        return result;
    }

    @LeetCodeSolution
    public ListNode solution2(ListNode[] lists){
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int s, int n){
        if(n < s){
            return null;
        }
        ListNode l1,l2;
        if(n == s){
            return lists[n];
        }
        else if(s + 1 == n){
            l1 = lists[s];
            l2 = lists[n];
        }
        else{
            l1 = merge(lists, s, (s + n) / 2);
            l2 = merge(lists, (s + n) / 2 + 1, n);
        }

        ListNode result = new ListNode(-1);
        ListNode p = result;
        while(l1 != null && l2 != null){
            ListNode temp;
            if(l1.val < l2.val){
                temp = l1;
                l1 = l1.next;
            }
            else{
                temp = l2;
                l2 = l2.next;
            }
            p.next = temp;
            p = p.next;
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }

        return result.next;
    }
}
