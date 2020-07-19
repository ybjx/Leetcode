package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/n-queens-ii/
 * 题目：
 * 题目：
 *     n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *     给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *     输入: 4
 *     输出: [
 *     [
 *         ".Q..",  // 解法 1
 *         "...Q",
 *         "Q...",
 *         "..Q."
 *     ],[
 *         "..Q.",  // 解法 2
 *         "Q...",
 *         "...Q",
 *         ".Q.."]
 *     ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class L052TotalNQueens extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int n){
        int [] x = new int[n];
        return calc(x, 0, n);
    }

    private int calc(int [] x, int level, int n){
        int total = 0;
        for(int i = 0; i < n; i++){
            x[level] = i;
            boolean ok = true;
            for(int j = 0; j < level; j++) {
                if ((x[j] - x[level] == level - j)
                        || (x[j] - x[level] == j - level)
                        || x[j] == x[level]
                        ) {
                    ok = false;
                    break;
                }
            }
            if(ok){
                if(level == n - 1){
                    total += 1;
                }
                else {
                    total += calc(x, level + 1, n);
                }
            }
        }
        return total;
    }
}
