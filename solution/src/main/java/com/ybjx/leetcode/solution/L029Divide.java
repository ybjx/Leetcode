package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/divide-two-integers/
 * 题目：
 *      给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *      返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *      输入: dividend = 10, divisor = 3
 *      输出: 3
 *
 * 示例 2:
 *      输入: dividend = 7, divisor = -3
 *      输出: -2
 *
 * 说明:
 *      被除数和除数均为 32 位有符号整数。
 *      除数不为 0。
 *      假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * @author ybjx
 * @date 2019/3/20 22:57
 */
public class L029Divide extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int dividend, int divisor){
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) <0;
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {
                result+=1<<i;
                t-=d<<i;
            }
        }
        return negative ? -result : result;
    }
}
