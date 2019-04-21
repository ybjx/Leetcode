package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.Arrays;

/**
 * 题目地址：https://leetcode-cn.com/problems/3sum-closest/
 * 题目：
 *     给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 *     返回这三个数的和。假定每组输入只存在唯一答案。
 * 示例：
 *     给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *     与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author ybjx
 * @date 2019/4/21 9:45
 */
public class L016ThreeSumClosest extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] nums, int target){
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int n = i + 1;
            int m = nums.length - 1;
            while(n < m){
                int temp = nums[i] + nums[n] + nums[m] - target;
                if(Math.abs(temp) < diff){
                    result = nums[i] + nums[n] + nums[m];
                    diff = Math.abs(temp);
                }
                if(temp == 0){
                    return result;
                }
                else if(temp < 0){
                    n ++;
                }
                else{
                    m --;
                }
            }
        }
        return result;
    }
}
