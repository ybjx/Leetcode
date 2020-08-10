package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/maximum-product-subarray/
 * 题目：
 *     给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 示例 1:
 *     输入: [2,3,-2,4]
 *     输出: 6
 *     解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 *     输入: [-2,0,-1]
 *     输出: 0
 *     解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class L152MaxProduct extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int t = nums[i];
            if(max < t){
                max = t;
            }
            for(int j = i + 1; j < nums.length; j++){
                t *= nums[j];
                if(t > max){
                    max = t;
                }
            }
        }
        return max;
    }
}
