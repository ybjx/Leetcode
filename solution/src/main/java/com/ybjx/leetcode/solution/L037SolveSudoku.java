package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/sudoku-solver/
 * 题目：
 *      编写一个程序，通过已填充的空格来解决数独问题。
 *      一个数独的解法需遵循如下规则：
 *          数字 1-9 在每一行只能出现一次。
 *          数字 1-9 在每一列只能出现一次。
 *          数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *          空白格用 '.' 表示。
 * @author ybjx
 * @date 2019/5/26 10:47
 */
public class L037SolveSudoku extends AbstractSolution {

    @JudgeMethod
    public void judge(char[][] board, char[][] result){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != result[i][j]){
                    throw new LeetCodeException("自定义结果校验不通过！");
                }
            }
        }
    }

    @LeetCodeSolution
    public void solution1(char[][] board){
        int[][] map = new int[3][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.' ){
                    continue;
                }
                map[0][j] |= (1 << (board[i][j] - '0'));
                map[1][i] |= (1 << (board[i][j] - '0'));
                map[2][(i / 3) * 3 + (j / 3)] |= (1 << (board[i][j] - '0'));
            }
        }
        buildMap(board, map, 0, 0);
    }
    private boolean buildMap(char[][] board,int[][] map, int i, int j){
        if(j == 9){
            return buildMap(board, map, i + 1, 0);
        }
        if(i == 9){
            return true;
        }
        if(board[i][j] != '.'){
            return buildMap(board, map, i, j + 1);
        }
        for(int m = 1; m < 10; m++){
            if((map[0][j] & (1 << m)) == 0
                && (map[1][i] & (1 << m)) == 0
                && (map[2][(i / 3) * 3 + (j / 3)] & (1 << m)) ==0
            ){
                map[0][j] |= (1 << m);
                map[1][i] |= (1 << m);
                map[2][(i / 3) * 3 + (j / 3)] |= (1 << m);
                board[i][j] = (char)('0' + m);
                if(buildMap(board, map, i, j + 1)){
                    return true;
                }
                else{
                    board[i][j] = '.';
                    map[0][j] &= ~(1 << m);
                    map[1][i] &= ~(1 << m);
                    map[2][(i / 3) * 3 + (j / 3)] &= ~(1 << m);
                }
            }
        }
        return false;
    }
}
