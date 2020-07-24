package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/spiral-matrix/
 * 题目：
 *     给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *     输入:
 *       [
 *         [ 1, 2, 3 ],
 *         [ 4, 5, 6 ],
 *         [ 7, 8, 9 ]
 *       ]
 *     输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 *     输入:
 *       [
 *         [1, 2, 3, 4],
 *         [5, 6, 7, 8],
 *         [9,10,11,12]
 *       ]
 *     输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class L054SpiralOrder extends AbstractSolution {

    @LeetCodeSolution
    public List<Integer> solution(int [][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int left  = 0;
        int top = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;

        update(left, top, right, bottom, result, matrix, 0);
        return result;
    }

    private void update(int left, int top, int right,
                        int bottom, List<Integer> result, int [][] matrix, int type){
        if(left >= right || top >= bottom){
            return;
        }
        if(type == 0){
            for(int i = left; i < right; i++){
                result.add(matrix[top][i]);
            }
            update(left, top + 1, right, bottom, result, matrix, 1);
        }
        else if(type == 1){
            for(int i = top; i < bottom; i++){
                result.add(matrix[i][right - 1]);
            }
            update(left, top, right - 1, bottom, result, matrix, 2);
        }
        else if(type == 2){
            for(int i = right - 1; i >= left; i--){
                result.add(matrix[bottom - 1][i]);
            }
            update(left, top, right, bottom - 1, result, matrix, 3);
        }
        else if(type == 3){
            for(int i = bottom - 1; i >= top; i--){
                result.add(matrix[i][left]);
            }
            update(left + 1, top, right, bottom, result, matrix, 0);
        }
    }
}
