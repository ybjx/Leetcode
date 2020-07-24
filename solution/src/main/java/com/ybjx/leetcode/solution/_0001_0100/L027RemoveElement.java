package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * @link https://leetcode-cn.com/problems/remove-element/
 * @author ybjx
 * @date 2019/3/20 22:47
 */
public class L027RemoveElement extends AbstractSolution {
    @JudgeMethod
    public void judge(int count, int[] param, int val, int[] result){
        for(int i = 0; i < count; i++){
            if(param[i] != result[i]){
                throw new LeetCodeException("自定义结果校验不通过");
            }
        }
    }

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
