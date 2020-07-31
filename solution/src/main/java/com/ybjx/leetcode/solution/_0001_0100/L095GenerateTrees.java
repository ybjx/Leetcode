package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 题目：
 *     给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 * 示例：
 *     输入：3
 *     输出：
 *       [
 *         [1,null,3,2],
 *         [3,2,null,1],
 *         [3,1,null,null,2],
 *         [2,1,3],
 *         [1,null,2,null,3]
 *       ]
 *     解释：
 *       以上的输出对应以下 5 种不同结构的二叉搜索树：
 *         1         3     3      2      1
 *          \       /     /      / \      \
 *           3     2     1      1   3      2
 *          /     /       \                 \
 *         2     1         2                 3
 */
public class L095GenerateTrees extends AbstractSolution {

    @LeetCodeSolution
    public List<TreeNode> solution(int n){
        return calc(1, n);
    }

    private List<TreeNode> calc(int s, int e){
        List<TreeNode> list = new ArrayList<>();
        for(int i = s; i <= e; i++){
            List<TreeNode> l1 = calc(s, i - 1);
            List<TreeNode> l2 = calc(i + 1, e);
            if(l1.size() == 0){
                l1.add(null);
            }
            if(l2.size() == 0){
                l2.add(null);
            }
            for (TreeNode t1 : l1) {
                for (TreeNode t2 : l2) {
                    TreeNode r = new TreeNode(i);
                    r.left = t1;
                    r.right = t2;
                    list.add(r);
                }
            }
        }
        return list;
    }
}
