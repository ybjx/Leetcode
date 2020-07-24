package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/search-insert-position/
 * @author ybjx
 * @date 2019/5/26 10:19
 */
public class L035SearchInsert extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return nums[left] >= target ? left : (left + 1);
    }
}
