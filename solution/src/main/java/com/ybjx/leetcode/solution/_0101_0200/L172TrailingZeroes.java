package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * 题目：
 *     给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *     输入: 3
 *     输出: 0
 *     解释: 3! = 6, 尾数中没有零。
 *
 * 示例 2:
 *     输入: 5
 *     输出: 1
 *     解释: 5! = 120, 尾数中有 1 个零.
 */
public class L172TrailingZeroes extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int n){
        int r = 0;
        while (n >= 5){
            r += (n / 5);
            n = n / 5;
        }
        return r;
    }
}
