package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/minimum-path-sum/
 * 题目：
 *     给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *     说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *     输入:
 *     [
 *       [1,3,1],
 *       [1,5,1],
 *       [4,2,1]
 *     ]
 *     输出: 7
 *     解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class L064MinPathSum extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[][] grid){
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                int l = Integer.MAX_VALUE;
                int t = Integer.MAX_VALUE;
                if(i > 0){
                    l = grid[i - 1][j];
                }
                if(j > 0){
                    t = grid[i][j - 1];
                }
                grid[i][j] += (l > t ? t: l);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
