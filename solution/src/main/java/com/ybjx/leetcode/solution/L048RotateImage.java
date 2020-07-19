package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/rotate-image/
 * 题目：
 *     给定一个 n × n 的二维矩阵表示一个图像。
 *     将图像顺时针旋转 90 度。
 *
 * 说明：
 *     你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *     给定 matrix =
 *     [
 *         [1,2,3],
 *         [4,5,6],
 *         [7,8,9]
 *     ],

 *     原地旋转输入矩阵，使其变为:
 *     [
 *         [7,4,1],
 *         [8,5,2],
 *         [9,6,3]
 *     ]
 *
 * 示例 2:
 *     给定 matrix =
 *     [
 *         [ 5, 1, 9,11],
 *         [ 2, 4, 8,10],
 *         [13, 3, 6, 7],
 *         [15,14,12,16]
 *     ],
 *     原地旋转输入矩阵，使其变为:
 *     [
 *         [15,13, 2, 5],
 *         [14, 3, 4, 1],
 *         [12, 6, 8, 9],
 *         [16, 7,10,11]
 *     ]
 */
public class L048RotateImage extends AbstractSolution {

    @JudgeMethod
    public void judge(int[][] nums, int[][] result){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] != result[i][j]) {
                    throw new LeetCodeException("自定义结果校验不成功");
                }
            }
        }
    }

    @LeetCodeSolution
    public void solution(int [][] matrix){
        int row = matrix.length;
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length - i -1; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = matrix[row - j - 1][row - i - 1];
                matrix[row - j - 1][row - i - 1] = matrix[i][row - j - 1];
                matrix[i][row - j - 1] = temp;
            }
        }
    }
}
