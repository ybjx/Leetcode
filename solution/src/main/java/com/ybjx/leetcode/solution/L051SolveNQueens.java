package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/n-queens/
 * 题目：
 *     n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *     给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *     每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
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
public class L051SolveNQueens extends AbstractSolution {

    @LeetCodeSolution
    public List<List<String>> solution(int n){
        int [] x = new int[n];
        return calc(x, 0, n);
    }

    private List<List<String>> calc(int [] x, int level, int n){
        List<List<String>> result = new ArrayList<>();
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
                    StringBuilder b = new StringBuilder();
                    for(int k = 0; k < n; k++){
                        b.append(".");
                    }
                    List<String> list = new ArrayList<>();
                    for(int k = 0; k < n ; k++){
                        b.replace(x[k],x[k] +1, "Q");
                        list.add(b.toString());
                        b.replace(x[k], x[k] + 1, ".");
                    }
                    result.add(list);
                }
                else {
                    result.addAll(calc(x, level + 1, n));
                }
            }
        }
        return result;
    }
}