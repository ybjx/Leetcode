package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/jump-game-ii/
 * 题目：
 *     给定一个非负整数数组，你最初位于数组的第一个位置。
 *     数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *     你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *     输入: [2,3,1,1,4]
 *     输出: 2
 *     解释: 跳到最后一个位置的最小跳跃数是 2。
 *          从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *     假设你总是可以到达数组的最后一个位置。
 */
public class L045JumpGameII extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int [] nums){
        if(nums.length <= 1){
            return 0;
        }
        int [] temp = new int [nums.length];
        for(int i = 0; i < temp.length; i++){
            temp[i] = Integer.MAX_VALUE;
        }
        temp[0] = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 1; j <= nums[i] && (i + j) < temp.length; j++){
                int t = temp[i] + 1;
                if(temp[i + j] > t){
                    temp[i + j] = t;
                }
            }
        }
        return temp[temp.length - 1];
    }
}
