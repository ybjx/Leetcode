package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/3sum/submissions/
 * 题目：
 *     给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 *     [
 *       [-1, 0, 1],
 *       [-1, -1, 2]
 *     ]
 * @author ybjx
 * @date 2019/4/20 14:03
 */
public class L015ThreeSum extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution1(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int aValue : nums) {
            if (map.containsKey(aValue)) {
                map.put(aValue, map.get(aValue) + 1);
            } else {
                map.put(aValue, 1);
            }
        }
        int zs = -1;
        int ze = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                if(zs == -1){
                    zs = i;
                }
                if(ze == -1){
                    ze = i;
                }
                break;
            }
            if(nums[i] == 0){
                ze = i;
                if(zs == -1){
                    zs = i;
                }
            }
        }
        if(zs < 0 || (ze - zs <= 1 &&(ze == 0 || ze == nums.length - 1) && nums[ze] == 0)){
            return result;
        }
        Set<String> cache = new HashSet<String>();

        for(int i = 0; i <= zs; i++){
            for(int j = nums.length - 1; j >= ze; j--){
                if(i == j){
                    continue;
                }
                int t = -(nums[i] + nums[j]);
                if(t < nums[i]){
                    continue;
                }
                if(t > nums[j]){
                    break;
                }
                int c = 1 + (t == nums[i] ? 1 : 0) + (t == nums[j] ? 1: 0);
                if(map.containsKey(t) && map.get(t) >= c){
                    String str = String.valueOf(nums[i])+ t + nums[j] ;
                    if(!cache.contains(str)){
                        List<Integer> ll = new ArrayList<Integer>();
                        ll.add(nums[i]);
                        ll.add(t);
                        ll.add(nums[j]);
                        result.add(ll);
                        cache.add(str);
                    }
                }
            }
        }
        return result;
    }

    @LeetCodeSolution
    public List<List<Integer>> solution2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int m = i + 1;
            int n = nums.length - 1;
            while(m < n){
                int t = nums[m] + nums[n] + nums[i];
                if(t == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    result.add(list);
                    while(m < n && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    while(m < n && nums[n] == nums[n - 1]){
                        n--;
                    }

                    m++;
                    n--;
                }
                else if(t > 0){
                    n --;
                }
                else {
                    m ++;
                }
            }
        }

        return result;
    }
}
