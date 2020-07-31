package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/subsets-ii/
 * 题目：
 *     给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *     说明：解集不能包含重复的子集。
 * 示例:
 *     输入: [1,2,2]
 *     输出:
 *       [
 *         [2],
 *         [1],
 *         [1,2,2],
 *         [2,2],
 *         [1,2],
 *         []
 *       ]
 */
public class L090SubsetsWithDup extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution(int[] nums){
        Arrays.sort(nums);
        return calc(nums, 0);
    }

    private List<List<Integer>> calc(int[] nums, int index){
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length <= index){
            result.add(new ArrayList<>());
            return result;
        }
        List<List<Integer>> list = calc(nums, index + 1);
        Set<String> set = new HashSet<>();
        for(List<Integer> l : list){
            String s = l.toString();
            if(!set.contains(s)){
                result.add(l);
                set.add(s);
            }
            List<Integer> t = new ArrayList<>(l);
            t.add(0, nums[index]);
            s = t.toString();
            if(!set.contains(s)){
                result.add(t);
                set.add(s);
            }
        }
        return result;
    }
}
