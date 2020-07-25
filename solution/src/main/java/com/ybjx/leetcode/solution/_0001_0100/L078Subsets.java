package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/subsets/
 * 题目：
 *     给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *     说明：解集不能包含重复的子集。
 *
 * 示例:
 *     输入: nums = [1,2,3]
 *     输出:
 *       [
 *         [3],
 *         [1],
 *         [2],
 *         [1,2,3],
 *         [1,3],
 *         [2,3],
 *         [1,2],
 *         []
 *       ]
 */
public class L078Subsets extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution(int [] nums){
        return calc(nums, nums.length - 1);
    }

    private List<List<Integer>> calc(int[] nums, int p){
        List<List<Integer>> result = new ArrayList<>();
        if(p < 0){
            result.add(new ArrayList<>());
            return result;
        }
        List<List<Integer>> list = calc(nums, p - 1);
        result.addAll(list);
        if(list.size() > 0) {
            for (List<Integer> l : list) {
                List<Integer> t = new ArrayList<>(l);
                t.add(nums[p]);
                result.add(t);
            }
        }

        return result;
    }
}
