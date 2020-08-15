package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/rotate-array/
 * 题目：
 *     给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *     输入: [1,2,3,4,5,6,7] 和 k = 3
 *     输出: [5,6,7,1,2,3,4]
 *     解释:
 *       向右旋转 1 步: [7,1,2,3,4,5,6]
 *       向右旋转 2 步: [6,7,1,2,3,4,5]
 *       向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 *     输入: [-1,-100,3,99] 和 k = 2
 *     输出: [3,99,-1,-100]
 *     解释:
 *       向右旋转 1 步: [99,-1,-100,3]
 *       向右旋转 2 步: [3,99,-1,-100]
 */
public class L189Rotate extends AbstractSolution {

    @JudgeMethod
    public void check(int[] param, int k, int[] result){
        for(int i = 0; i < param.length; i++){
            if(param[i] != result[i]){
                throw new LeetCodeException("结果不正确");
            }
        }
    }

    @LeetCodeSolution
    public void solution(int[] nums, int k){
        if(nums.length == 0){
            return;
        }
        k = k % nums.length;
        if(k == 0){
            return;
        }
        int [] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp,
                0,
                k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }
}
