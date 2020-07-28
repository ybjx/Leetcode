package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 题目：
 *     给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *     求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例:
 *     输入: [2,1,5,6,2,3]
 *     输出: 10
 */
public class L084LargestRectangleArea extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int []heights){
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int l = i;
            while(l >= 0 && heights[l] >= heights[i]){
                l --;
            }
            int r = i;
            while (r < heights.length && heights[r] >= heights[i]){
                r ++;
            }
            int s = (r - l - 1) * heights[i];
            if(max < s){
                max = s;
            }
        }
        return max;
    }
}
