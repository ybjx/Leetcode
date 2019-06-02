package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.Arrays;

/**
 * 题目地址：https://leetcode-cn.com/problems/first-missing-positive/
 * 题目：
 *      给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *      输入: [1,2,0]
 *      输出: 3
 *
 * 示例 2:
 *      输入: [3,4,-1,1]
 *      输出: 2
 *
 * 示例 3:
 *      输入: [7,8,9,11,12]
 *      输出: 1
 *
 * 说明:
 *      你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * @author ybjx
 * @date 2019/6/2 11:20
 */
public class L041FirstMissingPositive extends AbstractSolution {

    @LeetCodeSolution
    public int solution1(int[] nums){
        Arrays.sort(nums);
        int k = 1;
        for (int num : nums) {
            if (num == k) {
                k++;
            }
        }
        return k;
    }

    @LeetCodeSolution
    public int solution2(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int k = nums[i];
            while(k > 0 && k <= nums.length){
                if(nums[k - 1] == k){
                    break;
                }
                int t = nums[k - 1];
                nums[k - 1] = k;
                k = t;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
