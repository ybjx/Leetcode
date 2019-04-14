package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/reverse-integer/
 * 题目：
 *     给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *     输入: 123
 *     输出: 321
 * 示例 2:
 *     输入: -123
 *     输出: -321
 * 示例 3:
 *     输入: 120
 *     输出: 21
 */
public class L007Reverse extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int x){
        int r = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if (r > Integer.MAX_VALUE/10 || (r == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (r < Integer.MIN_VALUE/10 || (r == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            r = r * 10 + pop;

        }
        return r;
    }
}
