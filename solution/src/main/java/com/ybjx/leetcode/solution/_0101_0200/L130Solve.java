package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/surrounded-regions/
 * 题目：
 *     给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *     找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *       X X X X
 *       X O O X
 *       X X O X
 *       X O X X
 *     运行你的函数后，矩阵变为：
 *       X X X X
 *       X X X X
 *       X X X X
 *       X O X X
 *
 * 解释:
 *     被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 *     任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 *     如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class L130Solve extends AbstractSolution {
    @JudgeMethod
    public void check(char[][] param, char[][] result){
        for(int i = 0; i < param.length; i++){
            for(int j = 0; j < param[i].length; j++){
                if(param[i][j] != result[i][j]){
                    throw new LeetCodeException("结果不正确");
                }
            }
        }
    }

    @LeetCodeSolution
    public void solution(char[][] board){
        if(board.length <= 2 || board[0].length <= 2){
            return;
        }
        for(int i = 0; i < board.length; i++){
            update(board, i, 0);
            update(board, i, board[0].length - 1);
        }
        for(int i = 0; i < board[0].length; i++){
            update(board, 0, i);
            update(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(board[i][j] =='O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'K'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void update(char[][] board, int i, int j){
        if(board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'K';
        if(i > 0){
            update(board, i - 1, j);
        }
        if(i < board.length - 1){
            update(board, i + 1, j);
        }
        if(j > 0){
            update(board, i, j - 1);
        }
        if(j < board[0].length - 1){
            update(board, i, j + 1);
        }
    }
}
