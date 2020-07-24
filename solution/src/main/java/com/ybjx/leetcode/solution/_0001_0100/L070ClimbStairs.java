package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/climbing-stairs/
 * 题目：
 *     假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *     注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *     输入： 2
 *     输出： 2
 *     解释： 有两种方法可以爬到楼顶。
 *       1.  1 阶 + 1 阶
 *       2.  2 阶
 *
 * 示例 2：
 *     输入： 3
 *     输出： 3
 *     解释： 有三种方法可以爬到楼顶。
 *       1.  1 阶 + 1 阶 + 1 阶
 *       2.  1 阶 + 2 阶
 *       3.  2 阶 + 1 阶
 */
public class L070ClimbStairs extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int n){
        if(n < 3){
            return n;
        }
        int k1 = n / 2;
        int k2 = k1 + 1;

        int a = solution(k1);
        int b = solution(n - k1);
        int c = solution(k2);
        int d = solution(n - k2);

        return a * b + c * d - a * d;
    }
}
