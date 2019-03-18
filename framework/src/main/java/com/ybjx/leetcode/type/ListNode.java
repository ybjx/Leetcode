package com.ybjx.leetcode.type;

import com.ybjx.leetcode.common.Constant;

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
        builder.append(Constant.LEFT_SQUARE_BRACKET).append(this.val);
        if(next != null){
            String n = next.toString();
            if(n.startsWith(Constant.LEFT_SQUARE_BRACKET)){
                n = n.substring(1);
            }
            builder.append(Constant.COMMA).append(n);
        }
        else{
            builder.append(Constant.RIGHT_SQUARE_BRACKET);
        }
        return builder.toString();
    }
}
