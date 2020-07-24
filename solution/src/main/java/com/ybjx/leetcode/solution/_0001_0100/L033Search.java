package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 题目：
 *      假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *      ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *      搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *      你可以假设数组中不存在重复的元素。
 *      你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *      输入: nums = [4,5,6,7,0,1,2], target = 0
 *      输出: 4
 *
 * 示例 2:
 *      输入: nums = [4,5,6,7,0,1,2], target = 3
 *      输出: -1
 * @author ybjx
 * @date 2019/5/25 21:13
 */
public class L033Search extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (right + left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                if(target > nums[right] && nums[mid] <= nums[right]){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else{
                if(target < nums[left] &&  nums[mid] >= nums[left]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
