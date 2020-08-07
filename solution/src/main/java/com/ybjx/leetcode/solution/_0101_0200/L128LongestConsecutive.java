package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目地址：https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 题目：
 *     给定一个未排序的整数数组，找出最长连续序列的长度。
 *     要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *     输入: [100, 4, 200, 1, 3, 2]
 *     输出: 4
 *     解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class L128LongestConsecutive extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num: nums){
            if(map.containsKey(num)){
                continue;
            }
            int l = map.getOrDefault(num - 1, 0);
            int r = map.getOrDefault(num + 1, 0);
            map.put(num, l + r + 1);
            map.put(num - l, l + r + 1);
            map.put(num + r, l + r + 1);
            if(max < l + r + 1){
                max = l + r + 1;
            }
        }
        return max;
    }
}
