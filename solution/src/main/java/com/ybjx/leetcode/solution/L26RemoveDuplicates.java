package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * @author ybjx
 * @date 2019/3/19 23:51
 */
public class L26RemoveDuplicates extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int [] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = 0;
        int p = 1;
        while(p < nums.length){
            if(nums[p] != nums[len]){
                len ++;
                nums[len] = nums[p];
            }
            p ++;
        }
        return len + 1;
    }
}
