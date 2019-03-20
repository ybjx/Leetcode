package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * @author ybjx
 * @date 2019/3/20 22:57
 */
public class L29Divide extends AbstractSolution {

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
