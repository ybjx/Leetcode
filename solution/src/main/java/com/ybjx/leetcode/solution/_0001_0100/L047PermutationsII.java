package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/permutations-ii/
 * 题目：
 *     给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *     输入: [1,1,2]
 *     输出:
 *     [
 *         [1,1,2],
 *         [1,2,1],
 *         [2,1,1]
 *     ]
 */
public class L047PermutationsII extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution(int [] nums){
        return make(nums, 0);
    }

    private List<List<Integer>> make(int [] nums, int index){
        if(index >= nums.length){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length - 1 == index){
            List<Integer> list = new ArrayList<>();
            list.add(nums[index]);
            result.add(list);
        }
        else{
            List<List<Integer>> temp = make(nums, index + 1);
            Set<String> key = new HashSet<>();
            for(List<Integer> l: temp){
                for(int i = 0; i < l.size(); i++) {
                    List<Integer> list = new ArrayList<>(l);
                    list.add(i, nums[index]);
                    if(key.contains(list.toString())){
                        continue;
                    }
                    key.add(list.toString());
                    result.add(list);
                }
                List<Integer> list = new ArrayList<>(l);
                list.add(nums[index]);
                if(!key.contains(list.toString())) {
                    result.add(list);
                    key.add(list.toString());
                }
            }
        }
        return result;
    }
}
