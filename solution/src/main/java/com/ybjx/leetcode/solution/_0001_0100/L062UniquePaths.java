package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/unique-paths/
 * 题目：
 *     一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *     问总共有多少条不同的路径？
 *
 * 示例 1:
 *     输入: m = 3, n = 2
 *     输出: 3
 *     解释:
 *     从左上角开始，总共有 3 条路径可以到达右下角。
 *       1. 向右 -> 向右 -> 向下
 *       2. 向右 -> 向下 -> 向右
 *       3. 向下 -> 向右 -> 向右
 */
public class L062UniquePaths extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int m, int n){
        int [] temp = new int[m];
        temp[0] = 1;
        return calc(m, n, 0, temp);
    }

    private int calc(int m, int n, int index, int [] temp){
        if(index == n){
            return temp[m - 1];
        }
        for(int i = 1; i < m; i++){
            temp[i] += temp[i - 1];
        }
        return calc(m, n, index + 1, temp);
    }
}
