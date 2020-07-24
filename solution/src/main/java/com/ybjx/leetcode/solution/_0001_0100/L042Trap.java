package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/trapping-rain-water/
 * 题目：
 *      给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例:
 *      输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 *      输出: 6
 * @author ybjx
 * @date 2019/6/2 11:48
 */
public class L042Trap extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] height){
        if(height.length <= 2){
            return 0;
        }
        int max = height[0];
        int maxIndex = 0;
        for(int i = 1; i < height.length; i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }
        int total = 0;
        int lastHeight = height[0];
        for(int i = 1; i < maxIndex; i++){
            if(height[i] <= lastHeight){
                total += (lastHeight - height[i]);
            }
            else{
                lastHeight = height[i];
            }
        }
        lastHeight = height[height.length - 1];
        for(int i = height.length - 2; i > maxIndex; i--){
            if(height[i] <= lastHeight){
                total += (lastHeight - height[i]);
            }
            else{
                lastHeight = height[i];
            }
        }
        return total;
    }
}
