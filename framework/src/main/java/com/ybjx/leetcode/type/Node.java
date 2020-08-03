package com.ybjx.leetcode.type;

import com.alibaba.fastjson.JSONObject;

public class Node {

    public int val;

    public Node left;

    public Node right;

    public Node next;

    public Node(){}

    public Node(int val){
        this.val = val;
    }

    public Node(int val, Node _left, Node _right, Node _next){
        this.val = val;
        this.left = _left;
        this.right = _right;
        this.next = _next;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }

    @Override
    public boolean equals(Object n){
        if(!(n instanceof Node)){
            return false;
        }

        Node node = (Node)n;
        if(node.val != this.val){
            return false;
        }
        if(this.next != null){
            if(!this.next.equals(node.next)){
                return false;
            }
        }
        else{
            if(node.next != null){
                return false;
            }
        }
        if(this.left != null){
            if(!this.left.equals(node.left)){
                return false;
            }
        }
        else{
            if(node.left != null){
                return false;
            }
        }
        if(this.right != null){
            return this.right.equals(node.right);
        }
        else{
            return node.right == null;
        }
    }
}
