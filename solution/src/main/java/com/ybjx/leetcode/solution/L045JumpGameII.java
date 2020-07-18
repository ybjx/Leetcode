package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

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
