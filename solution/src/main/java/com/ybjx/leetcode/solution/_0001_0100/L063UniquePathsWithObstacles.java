package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/unique-paths-ii/
 * 题目：
 *     一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *     现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *     网格中的障碍物和空位置分别用 1 和 0 来表示。
 *     说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *     输入:
 *     [
 *       [0,0,0],
 *       [0,1,0],
 *       [0,0,0]
 *     ]
 *     输出: 2
 *     解释:
 *       3x3 网格的正中间有一个障碍物。
 *       从左上角到右下角一共有 2 条不同的路径：
 *       1. 向右 -> 向右 -> 向下 -> 向下
 *       2. 向下 -> 向下 -> 向右 -> 向右
 */
public class L063UniquePathsWithObstacles extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[][] obstacleGrid){
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int[] temp = new int[obstacleGrid[0].length];
        return calc(temp, obstacleGrid, 0);
    }

    private int calc(int[] temp, int[][] obstacleGrid, int index){
        if(index == obstacleGrid.length){
            return temp[obstacleGrid[0].length - 1];
        }
        for(int i = 0; i < obstacleGrid[index].length; i++){
            if(obstacleGrid[index][i] == 1){
                temp[i] = 0;
            }
            else{
                if(i >= 1){
                    temp[i] += temp[i - 1];
                }
                else{
                    if(index == 0) {
                        temp[i] = 1;
                    }
                }
            }
        }
        return calc(temp, obstacleGrid, index + 1);
    }
}
