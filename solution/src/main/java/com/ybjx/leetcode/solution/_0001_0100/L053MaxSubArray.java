package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/maximum-subarray/
 * 题目：
 *     给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *     输入: [-2,1,-3,4,-1,2,1,-5,4],
 *     输出: 6
 *
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class L053MaxSubArray extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int [] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i - 1] > 0){
                nums[i] += nums[i - 1];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}
