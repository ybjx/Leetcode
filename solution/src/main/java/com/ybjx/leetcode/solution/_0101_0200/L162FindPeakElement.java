package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/find-peak-element/
 * 题目：
 *     峰值元素是指其值大于左右相邻值的元素。
 *     给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *     数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *     你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *     输入: nums = [1,2,3,1]
 *     输出: 2
 *     解释: 3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 示例 2:
 *     输入: nums = [1,2,1,3,5,6,4]
 *     输出: 1 或 5
 *     解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *          或者返回索引 5， 其峰值元素为 6。
 */
public class L162FindPeakElement extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int [] nums){
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            if(r - l == 1){
                return nums[l] > nums[r] ? l : r;
            }
            int n = (l + r) / 2;
            if(nums[n] > nums[n - 1] && nums[n] > nums[n + 1]){
                return n;
            }
            if(nums[n - 1] > nums[n]){
                r = n;
            }
            else{
                l = n;
            }
        }
        return l;
    }
}
