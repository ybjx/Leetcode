package com.ybjx.leetcode.type;

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

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof ListNode)){
            return false;
        }
        ListNode node = (ListNode)obj;
        if(this.val != node.val){
            return false;
        }
        if(next == null){
            return node.next == null;
        }
        else{
            return next.equals(node.next);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(this.val);
        if(next != null){
            String n = next.toString();
            if(n.startsWith("[")){
                n = n.substring(1);
            }
            builder.append(",").append(n);
        }
        else{
            builder.append("]");
        }
        return builder.toString();
    }
}
