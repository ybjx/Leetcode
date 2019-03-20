package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * @link https://leetcode-cn.com/problems/remove-element/
 * @author ybjx
 * @date 2019/3/20 22:47
 */
public class L27RemoveElement extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] nums, int val){
        int p = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}
