package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/jump-game/
 * 题目：
 *     给定一个非负整数数组，你最初位于数组的第一个位置。
 *     数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *     判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *     输入: [2,3,1,1,4]
 *     输出: true
 *     解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 示例 2:
 *     输入: [3,2,1,0,4]
 *     输出: false
 *     解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class L055CanJump extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(int [] nums){
        return check(nums, 0);
    }

    private boolean check(int [] nums, int index){
        if(nums.length == index || nums.length - 1 == index){
            return true;
        }
        for(int i = 1; i <= nums[index]; i++){
            if(index + i >= nums.length){
                continue;
            }
            if(nums[index] + index >= nums[index + i] + index + i){
                continue;
            }
            if(check(nums, index + i)){
                return true;
            }
        }
        return nums[index] + index >= nums.length - 1;
    }
}
