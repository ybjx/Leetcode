package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 题目：
 *     给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *     输入: 3
 *     输出:
 *     [
 *       [ 1, 2, 3 ],
 *       [ 8, 9, 4 ],
 *       [ 7, 6, 5 ]
 *     ]
 */
public class L059GenerateMatrix extends AbstractSolution {

    @LeetCodeSolution
    public int[][] solution(int n){
        int [][] result = new int[n][n];
        update(0, 0, n, n, result, 1, 0);
        return result;
    }

    private void update(int left, int top, int right,
                        int bottom, int [][] matrix, int count, int type){
        if(left >= right || top >= bottom){
            return;
        }
        int c = 0;
        if(type == 0){
            for(int i = left; i < right; i++){
                matrix[top][i] = count + c;
                c++;
            }
            update(left, top + 1, right, bottom, matrix, matrix[top][right -1] + 1, 1);
        }
        else if(type == 1){
            for(int i = top; i < bottom; i++){
                matrix[i][right - 1] = count + c;
                c++;
            }
            update(left, top, right - 1, bottom, matrix, matrix[bottom - 1][right - 1] + 1,2);
        }
        else if(type == 2){
            for(int i = right - 1; i >= left; i--){
                matrix[bottom - 1][i] = count + c;
                c++;
            }
            update(left, top, right, bottom - 1, matrix, matrix[bottom - 1][left] + 1, 3);
        }
        else if(type == 3){
            for(int i = bottom - 1; i >= top; i--){
                matrix[i][left] = count + c;
                c++;
            }
            update(left + 1, top, right, bottom, matrix, matrix[top][left]  + 1, 0);
        }
    }
}
