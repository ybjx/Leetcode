package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/number-of-islands/
 * 题目：
 *     给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *     岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *     此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *     输入:
 *       [
 *         ['1','1','1','1','0'],
 *         ['1','1','0','1','0'],
 *         ['1','1','0','0','0'],
 *         ['0','0','0','0','0']
 *       ]
 *     输出: 1
 *
 * 示例 2:
 *     输入:
 *       [
 *         ['1','1','0','0','0'],
 *         ['1','1','0','0','0'],
 *         ['0','0','1','0','0'],
 *         ['0','0','0','1','1']
 *       ]
 *     输出: 3
 *     解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class L200NumIslands extends AbstractSolution {

    @LeetCodeSolution
    public int solution(char [][] grid){
        int t = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    t++;
                    update(grid, i, j);
                }
            }
        }
        return t;
    }

    private void update(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if(grid[i][j] == '1'){
            grid[i][j] = 'X';
            update(grid, i - 1, j);
            update(grid, i, j - 1);
            update(grid, i + 1, j);
            update(grid, i, j + 1);
        }
    }
}
