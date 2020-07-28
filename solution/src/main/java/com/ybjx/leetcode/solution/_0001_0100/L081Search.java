package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * 题目：
 *     假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *     ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *     编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *     输入: nums = [2,5,6,0,0,1,2], target = 0
 *     输出: true
 *
 * 示例 2:
 *     输入: nums = [2,5,6,0,0,1,2], target = 3
 *     输出: false
 */
public class L081Search extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            while (l + 1 < nums.length && nums[l] == nums[l + 1]){
                l ++;
                if(l > r){
                    break;
                }
            }
            while(r - 1 >= 0 && nums[r] == nums[r - 1]){
                r--;
            }
            int n = (l + r) / 2;
            if(target > nums[n]){
                if(nums[n] >= nums[l]){
                    l = n + 1;
                }
                else{
                    if(target <= nums[r]){
                        l = n + 1;
                    }
                    else{
                        r = n - 1;
                    }
                }
            }
            else if(target < nums[n]){
                if(nums[n] >= nums[l]){
                    if(target >= nums[l]){
                        r = n - 1;
                    }
                    else{
                        l = n + 1;
                    }
                }
                else{
                    r = n - 1;
                }
            }
            else{
                return true;
            }
        }
        return false;
    }
}
