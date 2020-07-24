package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/valid-sudoku/
 * 题目：
 *      判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *          数字 1-9 在每一行只能出现一次。
 *          数字 1-9 在每一列只能出现一次。
 *          数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @author ybjx
 * @date 2019/5/26 10:29
 */
public class L036IsValidSudoku extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(char[][] board){
        int iLine,jLine,cLine;
        for(int i = 0; i < 9; i++){
            iLine = 0;
            jLine = 0;
            cLine = 0;
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if((iLine & (1 << (board[i][j] - '0'))) != 0){
                        return false;
                    }
                    iLine |= (1 << (board[i][j] - '0'));
                }
                if(board[j][i] != '.'){
                    if((jLine & (1 << (board[j][i] - '0'))) != 0){
                        return false;
                    }
                    jLine |= (1 << (board[j][i] - '0'));
                }
                int m = (i / 3) * 3 + j / 3;
                int n = (i % 3) * 3 + (j % 3);
                if(board[m][n] != '.'){
                    if((cLine & (1 << (board[m][n] - '0'))) != 0){
                        return false;
                    }
                    cLine |= (1 << (board[m][n] - '0'));
                }
            }
        }

        return true;
    }
}
