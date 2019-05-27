package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/combination-sum/
 * 题目：
 *      给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 *      candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *      所有数字（包括 target）都是正整数。
 *      解集不能包含重复的组合。
 *
 * 示例 1:
 *      输入: candidates = [2,3,6,7], target = 7,
 *      所求解集为:
 *          [
 *              [7],
 *              [2,2,3]
 *          ]
 *
 * 示例 2:
 *      输入: candidates = [2,3,5], target = 8,
 *      所求解集为:
 *          [
 *              [2,2,2,2],
 *              [2,3,3],
 *              [3,5]
 *          ]
 * @author ybjx
 * @date 2019/5/27 21:55
 */
public class L039CombinationSum extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution1(int[] candidates, int target){
        Arrays.sort(candidates);
        return find(candidates, 0, target);
    }

    private List<List<Integer>> find(int[] candidates, int start, int target){
        List<List<Integer>> result = new ArrayList<>();
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] < target){
                List<List<Integer>> temp = find(candidates, i, target - candidates[i]);
                if(temp.size() > 0){
                    for(List<Integer> l: temp){
                        l.add(0, candidates[i]);
                        result.add(l);
                    }
                }
            }
            else if(candidates[i] == target){
                List<Integer> l = new ArrayList<>();
                l.add(candidates[i]);
                result.add(l);
            }
            else{
                break;
            }
        }
        return result;
    }
}
