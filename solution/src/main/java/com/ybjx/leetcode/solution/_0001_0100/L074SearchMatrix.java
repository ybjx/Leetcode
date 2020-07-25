package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 题目：
 *     编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *     每行中的整数从左到右按升序排列。
 *     每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1:
 *     输入:
 *     matrix = [
 *     [1,   3,  5,  7],
 *     [10, 11, 16, 20],
 *     [23, 30, 34, 50]
 *     ]
 *     target = 3
 *     输出: true
 *
 * 示例 2:
 *     输入:
 *       matrix = [
 *         [1,   3,  5,  7],
 *         [10, 11, 16, 20],
 *         [23, 30, 34, 50]
 *       ]
 *       target = 13
 *     输出: false
 */
public class L074SearchMatrix extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n;
        int p = (l + r) /2;
        while(l <= p && p < r){
            int t = matrix[p / n][p % n];
            if( t == target){
                return true;
            }
            else if(t < target){
                l = p + 1;
            }
            else if(t > target){
                r = p;
            }
            p = (l + r) / 2;
        }

        return false;
    }
}
