package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/4sum/submissions/
 * 题目：
 *     给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 *     判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *     答案中不可以包含重复的四元组。
 *
 * 示例：
 *     给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *     满足要求的四元组集合为：
 *     [
 *       [-1,  0, 0, 1],
 *       [-2, -1, 1, 2],
 *       [-2,  0, 0, 2]
 *     ]
 * @author ybjx
 * @date 2019/4/21 10:22
 */
public class L018FourSum extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution1(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> cache = new HashSet<String>();
        for(int a = 0; a < nums.length - 3; a++){
            for(int b = a + 1; b < nums.length - 2; b++){
                int i = b + 1;
                int j = nums.length - 1;
                int t = target - nums[a] - nums[b];
                while (i < j){
                    int k = nums[i] + nums[j];
                    if( k == t){
                        String str = nums[a] + "," + nums[b] + "," + nums[i] + "," + nums[j];
                        if(!cache.contains(str)){
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[a]);
                            list.add(nums[b]);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            result.add(list);
                            cache.add(str);
                        }
                        i++;
                        j--;
                    } else if (k < t){
                        i++;
                    } else{
                        j --;
                    }
                }
            }
        }
        return result;
    }

    @LeetCodeSolution
    public List<List<Integer>> solution2(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int a = 0; a < nums.length - 3; a++){
            if(a > 0 && nums[a] == nums[a - 1]){
                continue;
            }
            for(int b = a + 1; b < nums.length - 2; b++){
                if(b > a + 1 && nums[b] == nums[b - 1]){
                    continue;
                }
                int i = b + 1;
                int j = nums.length - 1;
                int t = target - nums[a] - nums[b];
                while (i < j){
                    int k = nums[i] + nums[j];
                    if( k == t){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        result.add(list);
                        while(i < j && nums[i] == nums[i + 1]){
                            i++;
                        }
                        while(i < j && nums[j] == nums[j - 1]){
                            j--;
                        }
                        i++;
                        j--;
                    } else if (k < t){
                        i++;
                    } else{
                        j --;
                    }
                }
            }
        }
        return result;
    }
}
