package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/permutation-sequence/
 * 题目：
 *     给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *     按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *       "123"
 *       "132"
 *       "213"
 *       "231"
 *       "312"
 *       "321"
 *     给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *     给定 n 的范围是 [1, 9]。
 *     给定 k 的范围是[1,  n!]。
 *
 * 示例 1:
 *     输入: n = 3, k = 3
 *     输出: "213"
 *
 * 示例 2:
 *     输入: n = 4, k = 9
 *     输出: "2314"
 */
public class L060GetPermutation extends AbstractSolution {

    @LeetCodeSolution
    public String solution(int n, int k){
        StringBuilder s = new StringBuilder();
        int K = k;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        for(int i = 0; i < n; i++){
            int N = getN(n - i - 1);
            int m = (K - 1) / N;
            s.append(list.get(m));
            list.remove(m);
            K = K - m * N;
        }

        return s.toString();
    }

    private int getN(int n){
        if(n <= 1){
            return 1;
        }
        return getN(n - 1) * n;
    }
}
