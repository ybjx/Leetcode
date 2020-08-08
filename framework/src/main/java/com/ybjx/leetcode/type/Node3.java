package com.ybjx.leetcode.type;

import java.util.*;

public class Node3 {
    public int val;
    public Node3 next;
    public Node3 random;

    public Node3(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public boolean equals(Object n){
        if(!(n instanceof Node3)){
            return false;
        }
        Node3 node = (Node3)n;
        return this.toString().equals(node.toString());
    }

    @Override
    public String toString(){
        List<Node3> list = new ArrayList<Node3>();
        list.add(this);
        Node3 p = this.next;
        while (p != null){
            list.add(p);
            p = p.next;
        }
        StringBuilder b = new StringBuilder();
        b.append("[");
        for(Node3 n: list){
            b.append("[");
            b.append(n.val).append(",");
            if(n.random != null){
                for(int i = 0; i < list.size(); i++){
                    if(n.random == list.get(i)){
                        b.append(i);
                        break;
                    }
                }
            }
            else{
                b.append("null");
            }
            b.append("],");
        }
        b.replace(b.length() - 1, b.length(), "]");
        return b.toString();
    }
}
