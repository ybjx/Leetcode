package com.ybjx.leetcode.type;

import com.ybjx.leetcode.common.Constant;

public class TreeNode {
    /**
     * 值
     */
    public int val;
    /**
     * 左节点
     */
    public TreeNode left;
    /**
     * 右节点
     */
    public TreeNode right;

    /**
     * 构造方法
     * @param x 值
     */
    public TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof TreeNode)){
            return false;
        }
        TreeNode node = (TreeNode)obj;
        if(this.val != node.val){
            return false;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(Constant.LEFT_SQUARE_BRACKET).append(this.val).append(Constant.COMMA);
        String n;
        if(left != null){
            n = left.toString();
            n = n.substring(1, n.length() - 1);
        }
        else{
            n = "null";
        }
        builder.append(n).append(Constant.COMMA);
        if(right != null){
            n = right.toString();
            n = n.substring(1, n.length() - 1);
        }
        else{
            n = "null";
        }
        builder.append(n);
        builder.append(Constant.RIGHT_SQUARE_BRACKET);
        return builder.toString();
    }
}
