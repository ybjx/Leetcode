package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 题目：
 *      给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *      你的算法时间复杂度必须是 O(log n) 级别。
 *      如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *      输入: nums = [5,7,7,8,8,10], target = 8
 *      输出: [3,4]
 *
 * 示例 2:
 *      输入: nums = [5,7,7,8,8,10], target = 6
 *      输出: [-1,-1]
 * @author ybjx
 * @date 2019/5/26 10:08
 */
public class L034SearchRange extends AbstractSolution {

    @LeetCodeSolution
    public int[] solution(int[] nums, int target){
        int[] result = new int[2];
        int left = 0;
        int right =  nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                result[0] = mid;
                result[1] = mid;
                int temp = mid - 1;
                while (temp >= left && nums[temp] == target){
                    result[0] = temp;
                    temp --;
                }
                temp = mid + 1;
                while(temp <= right && nums[temp] == target){
                    result[1] = temp;
                    temp ++;
                }
                return result;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

}
