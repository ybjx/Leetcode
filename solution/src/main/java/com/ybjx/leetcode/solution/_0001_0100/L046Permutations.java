package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

public class L046Permutations extends AbstractSolution {

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

            for(List<Integer> l: temp){
                for(int i = 0; i < l.size(); i++) {
                    List<Integer> list = new ArrayList<>(l);
                    list.add(i, nums[index]);
                    result.add(list);
                }
                List<Integer> list = new ArrayList<>(l);
                list.add(nums[index]);
                result.add(list);
            }
        }
        return result;
    }
}
