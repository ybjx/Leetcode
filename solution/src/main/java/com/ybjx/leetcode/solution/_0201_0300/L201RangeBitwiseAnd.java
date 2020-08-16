package com.ybjx.leetcode.solution._0201_0300;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 题目：
 *     给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 *     输入: [5,7]
 *     输出: 4
 *
 * 示例 2:
 *     输入: [0,1]
 *     输出: 0
 */
public class L201RangeBitwiseAnd extends AbstractSolution{

    @LeetCodeSolution
    public int solution(int m, int n) {
        int t = 0;
        for(int i = 31; i >= 0; i--){
            int m1 = (m & (1 << i));
            int n1 = (n & (1 << i));
            if(m1 == n1){
                t += m1;
            }
            else{
                break;
            }
        }
        return t;
    }
}
