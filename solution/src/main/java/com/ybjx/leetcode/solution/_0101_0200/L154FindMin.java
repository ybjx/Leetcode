package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 题目：
 *     假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *     ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *     请找出其中最小的元素。
 *     注意数组中可能存在重复的元素。
 *
 * 示例 1：
 *     输入: [1,3,5]
 *     输出: 1
 *
 * 示例 2：
 *     输入: [2,2,2,0,1]
 *     输出: 0
 */
public class L154FindMin extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int []nums){
        int l = 0;
        int r = nums.length - 1;
        int n = (l + r) / 2;
        while (l < r){
            if(r - l == 1){
                return nums[r] > nums[l] ? nums[l]:nums[r];
            }
            if(nums[l] == nums[l + 1]){
                l += 1;
            }
            else if(nums[r] == nums[r - 1]){
                r -= 1;
            }
            else if(nums[n] >nums[l]){
                if(nums[r] <= nums[l]){
                    l = n;
                }
                else{
                    r = n;
                }
            }
            else{
                r = n;
            }
            n = (l + r) / 2;
        }
        return nums[l];
    }
}
