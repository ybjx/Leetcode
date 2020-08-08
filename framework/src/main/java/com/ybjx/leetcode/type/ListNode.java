package com.ybjx.leetcode.type;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表数据类型
 * @author ybjx
 * @date 2019/3/18 23:08
 */
public class ListNode {
    /**
     * 存储的值
     */
    public int val;

    /**
     * 下一个节点
     */
    public ListNode next;

    /**
     * 构造方法
     * @param x 节点的值
     */
    public ListNode(int x) { val = x; }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof ListNode)){
            return false;
        }
        return this.toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode p = this;
        StringBuilder b = new StringBuilder();
        b.append("[");
        while (p != null){
            boolean end = false;
            for (ListNode aList : list) {
                if (aList == p) {
                    end = true;
                }
            }
            if(end){
                break;
            }
            b.append(p.val).append(",");
            list.add(p);
            p = p.next;
        }
        b.replace(b.length() - 1, b.length(), "]");
        return b.toString();
    }
}
