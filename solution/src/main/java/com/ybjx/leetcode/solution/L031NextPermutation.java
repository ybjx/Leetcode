package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/next-permutation/
 * 题目：
 *      实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *      如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *      必须原地修改，只允许使用额外常数空间。
 *
 * 示例：
 *      以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 *      1,2,3 → 1,3,2
 *      3,2,1 → 1,2,3
 *      1,1,5 → 1,5,1
 * @author ybjx
 * @date 2019/5/25 14:49
 */
public class L031NextPermutation extends AbstractSolution {

    @JudgeMethod
    public void judge(int[] nums, int[] result){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != result[i]){
                throw new LeetCodeException("自定义结果校验不成功");
            }
        }
    }

    @LeetCodeSolution
    public void solution(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int p = -1;
        int last = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < last){
                p = i;
                break;
            }
            else{
                last = nums[i];
            }
        }
        if(p != -1) {
            for (int i = nums.length - 1; i > p; i--) {
                if (nums[i] > nums[p]){
                    int t = nums[p];
                    nums[p] = nums[i];
                    nums[i] = t;
                    break;
                }
            }
        }
        p ++;
        for(int i = 0; i < (nums.length - p) / 2; i++){
            int t = nums[p + i];
            nums[p + i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = t;
        }
    }
}
