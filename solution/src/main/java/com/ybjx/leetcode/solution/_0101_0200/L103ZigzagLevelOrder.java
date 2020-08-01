package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 题目：
 *     给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 *     给定二叉树 [3,9,20,null,null,15,7],
 *           3
 *          / \
 *         9  20
 *           /  \
 *          15   7
 *     返回锯齿形层次遍历如下：
 *       [
 *         [3],
 *         [20,9],
 *         [15,7]
 *       ]
 */
public class L103ZigzagLevelOrder extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> list = levelOrder(root);

        for(int i = 1; i < list.size(); i+=2){
            List<Integer> l = list.get(i);
            List<Integer> t = new ArrayList<>();
            for(Integer v: l){
                t.add(0, v);
            }
            l.clear();
            l.addAll(t);
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<List<Integer>> left = levelOrder(root.left);
        List<List<Integer>> right = levelOrder(root.right);

        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        list.add(temp);
        int t = 0;
        while(t < left.size() || t < right.size()){
            List<Integer> l;
            if(t < left.size()){
                l = left.get(t);
            }
            else{
                l = new ArrayList<>();
            }
            if(t < right.size()){
                l.addAll(right.get(t));
            }
            if(l.size() > 0){
                list.add(l);
            }
            t++;
        }
        return list;
    }
}
