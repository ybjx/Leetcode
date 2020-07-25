package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/set-matrix-zeroes/
 * 题目：
 *     给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *     输入:
 *       [
 *         [1,1,1],
 *         [1,0,1],
 *         [1,1,1]
 *       ]
 *     输出:
 *       [
 *         [1,0,1],
 *         [0,0,0],
 *         [1,0,1]
 *       ]
 *
 * 示例 2:
 *     输入:
 *       [
 *         [0,1,2,0],
 *         [3,4,5,2],
 *         [1,3,1,5]
 *       ]
 *     输出:
 *       [
 *         [0,0,0,0],
 *         [0,4,5,0],
 *         [0,3,1,0]
 *       ]
 */
public class L073SetZeroes extends AbstractSolution {
    @JudgeMethod
    public void judge(int[][] param, int[][] result){
        for(int i = 0; i < param.length; i++){
            for(int j = 0; j < param[i].length; j++) {
                if (param[i][j] != result[i][j]) {
                    throw new LeetCodeException("自定义结果校验不通过");
                }
            }
        }
    }

    @LeetCodeSolution
    public void solution(int [][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int t = -1;
        int l = -1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if(i == 0){
                        t = 0;
                    }
                    if(j == 0){
                        l = 0;
                    }
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < matrix[i].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                for(int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(t == 0){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if(l == 0){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
