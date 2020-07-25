package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/combinations/
 * 题目：
 *     给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *     输入: n = 4, k = 2
 *     输出:
 *     [
 *       [2,4],
 *       [3,4],
 *       [2,3],
 *       [1,2],
 *       [1,3],
 *       [1,4],
 *     ]
 */
public class L077Combine extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        if(k == 0){
            return result;
        }
        else if(k == 1){
            for(int i = 1; i <= n; i++){
                List<Integer> l = new ArrayList<>();
                l.add(i);
                result.add(l);
            }
            return result;
        }
        List<List<Integer>> list = solution(n, k - 1);
        for(List<Integer> l: list){
            for(int i = l.get(l.size() - 1) + 1; i <= n; i++){
                List<Integer> ll = new ArrayList<>(l);
                ll.add(i);
                result.add(ll);
            }
        }
        return result;
    }
}
