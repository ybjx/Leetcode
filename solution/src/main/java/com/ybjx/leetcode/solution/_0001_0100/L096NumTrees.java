package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 题目：
 *     给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *     输入: 3
 *     输出: 5
 *     解释:
 *       给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *         1         3     3      2      1
 *          \       /     /      / \      \
 *           3     2     1      1   3      2
 *          /     /       \                 \
 *         2     1         2                 3
 */
public class L096NumTrees extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int n){
        int [] temp = new int[n];
        return calc(1, n, temp);
    }

    private int calc(int s, int e, int [] temp){
        if(s > e){
            return 0;
        }
        if(temp[e - s] != 0){
            return temp[e - s];
        }
        int t = 0;
        for(int i = s; i <= e; i++){
            int l = calc(s, i - 1, temp);
            int r = calc(i + 1, e, temp);
            if(l == 0){
                l = 1;
            }
            if(r == 0){
                r = 1;
            }
            t += (l * r);
        }
        temp[e  - s] = t;
        return t;
    }
}
