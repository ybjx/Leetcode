package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/powx-n/
 * 题目：
 *     实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *     输入: 2.00000, 10
 *     输出: 1024.00000
 *
 * 示例 2:
 *     输入: 2.10000, 3
 *     输出: 9.26100
 *
 * 示例 3:
 *     输入: 2.00000, -2
 *     输出: 0.25000
 *     解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 *     -100.0 < x < 100.0
 *     n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class L050PowxN extends AbstractSolution {

    @LeetCodeSolution
    public double solution(double x, int n){
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        else if(n == -1){
            return 1 / x;
        }
        else if(n == 1){
            return x;
        }
        int m = n / 2;
        double t = solution(x, m);
        return t * t * solution(x, n - 2 * m);
    }
}