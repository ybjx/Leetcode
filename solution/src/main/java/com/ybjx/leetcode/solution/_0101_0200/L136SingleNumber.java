package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目地址：https://leetcode-cn.com/problems/single-number/
 * 题目：
 *     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 示例 1:
 *     输入: [2,2,1]
 *     输出: 1
 *
 * 示例 2:
 *     输入: [4,1,2,1,2]
 *     输出: 4
 */
public class L136SingleNumber extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int n: nums){
            if(map.get(n) == 1){
                return n;
            }
        }
        return 0;
    }

    @LeetCodeSolution
    public int solution2(int[] nums){
        int n = nums[0];
        for(int i = 1; i < nums.length; i++){
            n = n ^ nums[i];
        }
        return n;
    }
}
