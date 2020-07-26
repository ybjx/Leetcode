package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/word-search/
 * 题目：
 *     给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *     单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *     board =
 *     [
 *       ['A','B','C','E'],
 *       ['S','F','C','S'],
 *       ['A','D','E','E']
 *     ]
 *     给定 word = "ABCCED", 返回 true
 *     给定 word = "SEE", 返回 true
 *     给定 word = "ABCB", 返回 false
 *
 * 提示：
 *     board 和 word 中只包含大写和小写英文字母。
 *     1 <= board.length <= 200
 *     1 <= board[i].length <= 200
 *     1 <= word.length <= 10^3
 */
public class L079Exist extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(char[][] board, String word){
        if(word.length() == 0){
            return false;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(check(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int m, int n, int index){
        if(board[m][n] != word.charAt(index)){
            return false;
        }
        if(index + 1 == word.length()){
            return true;
        }
        board[m][n] = 0;
        if(m > 0){
            if(check(board, word, m - 1, n, index + 1)){
                return true;
            }
        }
        if(n > 0){
            if(check(board, word, m, n - 1, index + 1)){
                return true;
            }
        }
        if(m < board.length - 1){
            if(check(board, word, m + 1, n, index + 1)){
                return true;
            }
        }
        if(n < board[m].length - 1){
            if(check(board, word, m, n + 1, index + 1)){
                return true;
            }
        }
        board[m][n] = word.charAt(index);
        return false;
    }
}
