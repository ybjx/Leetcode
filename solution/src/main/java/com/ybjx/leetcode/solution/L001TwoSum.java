package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * 题目地址：https://leetcode-cn.com/problems/two-sum/
 * 题目：
 *     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例：
 *     给定 nums = [2, 7, 11, 15], target = 9
 *     因为 nums[0] + nums[1] = 2 + 7 = 9
 *     所以返回 [0, 1]
 * @author ybjx
 * @date 2019/3/24 12:18
 */
public class L001TwoSum  {

    @LeetCodeSolution(name = "双循环解法")
    public int[] solution1(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(8);
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            if (map.containsKey(t) && map.get(t) != i) {
                res[0] = i;
                res[1] = map.get(t);
                break;
            }
        }
        return res;
    }

    @LeetCodeSolution(name = "单循环解法")
    public int[] solution2(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(8);
        int[] res = new int[]{-1,-1};
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
