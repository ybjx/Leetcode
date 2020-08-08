package com.ybjx.leetcode.type;

import java.util.*;

public class Node2 {
    public int val;
    public List<Node2> neighbors;

    public Node2() {
        val = 0;
        neighbors = new ArrayList<Node2>();
    }

    public Node2(int _val) {
        val = _val;
        neighbors = new ArrayList<Node2>();
    }

    public Node2(int _val, ArrayList<Node2> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public boolean equals(Object n){
        if(!(n instanceof Node2)){
            return false;
        }
        Node2 node = (Node2)n;
        if(node.val != this.val){
            return false;
        }
        if(node.neighbors == null && this.neighbors == null) {
            return true;
        }
        if(node.neighbors == null || this.neighbors == null){
            return false;
        }
        if(node.neighbors.size() != this.neighbors.size()){
            return false;
        }
        for(int i = 0; i < node.neighbors.size(); i++){
            if(node.neighbors.get(i).val != this.neighbors.get(i).val){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        if(neighbors == null || neighbors.size() == 0){
            return "[]";
        }
        Map<Integer, Node2> map = new HashMap<Integer, Node2>();

        Stack<Node2> stack = new Stack<Node2>();
        stack.add(this);
        while(stack.size() > 0){
            Node2 n = stack.pop();
            if(!map.containsKey(n.val)){
                map.put(n.val, n);
                if(n.neighbors != null) {
                    for (Node2 node2 : n.neighbors) {
                        stack.push(node2);
                    }
                }
            }
        }

        StringBuilder b = new StringBuilder();
        b.append("[");
        for(int i = 1; i < map.size() + 1; i++){
            Node2 n = map.get(i);
            b.append("[");
            if(n.neighbors != null && n.neighbors.size() > 0){
                for(Node2 node: n.neighbors){
                    b.append(node.val).append(",");
                }
                b.replace(b.length() - 1, b.length(), "");
            }
            b.append("],");
        }
        b.replace(b.length() - 1, b.length(), "]");
        return b.toString();
    }
}
