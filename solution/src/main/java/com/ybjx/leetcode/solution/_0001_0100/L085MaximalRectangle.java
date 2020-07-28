package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/maximal-rectangle/
 * 题目：
 *     给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *     输入:
 *       [
 *         ["1","0","1","0","0"],
 *         ["1","0","1","1","1"],
 *         ["1","1","1","1","1"],
 *         ["1","0","0","1","0"]
 *       ]
 *     输出: 6
 */
public class L085MaximalRectangle extends AbstractSolution {

    @LeetCodeSolution
    public int solution(char[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] temp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    if(j == 0){
                        temp[i][j] = 1;
                    }
                    else{
                        temp[i][j] = temp[i][j - 1] + 1;
                    }
                }
            }
        }
        int max = 0;
        for(int j = 0; j < temp[0].length; j++){
            for(int m = 0; m < temp.length; m++){
                int l = m;
                while(l >= 0 && temp[l][j] >= temp[m][j]){
                    l --;
                }
                int r = m;
                while (r < temp.length && temp[r][j] >= temp[m][j]){
                    r ++;
                }
                int s = (r - l - 1) * temp[m][j];
                if(max < s){
                    max = s;
                }
            }
        }
        return max;
    }
}
