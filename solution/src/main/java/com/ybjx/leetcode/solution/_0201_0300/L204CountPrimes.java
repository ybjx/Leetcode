package com.ybjx.leetcode.solution._0201_0300;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/count-primes/
 * 题目：
 *     统计所有小于非负整数 n 的质数的数量。
 * 示例:
 *     输入: 10
 *     输出: 4
 *     解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class L204CountPrimes extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int n){
        boolean [] cache = new boolean[n];
        for(int i = 2; i * i < n; i++){
            if(cache[i * i]){
                continue;
            }
            for(int k = i * i; k < n; k+= i){
                cache[k] = true;
            }
        }
        int t = 0;
        for(int i = 2; i < n; i++){
            if(!cache[i]){
                t++;
            }
        }
        return t;
    }
}
