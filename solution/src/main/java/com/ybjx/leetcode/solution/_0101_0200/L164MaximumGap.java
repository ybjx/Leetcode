package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.Arrays;

/**
 * 题目地址：https://leetcode-cn.com/problems/maximum-gap/
 * 题目：
 *     给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *     如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *     输入: [3,6,9,1]
 *     输出: 3
 *     解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 示例 2:
 *     输入: [10]
 *     输出: 0
 *     解释: 数组元素个数小于 2，因此返回 0。
 */
public class L164MaximumGap extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int [] nums){
        Arrays.sort(nums);
        int max = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] > max){
                max = nums[i] - nums[i - 1];
            }
        }
        return max;
    }

    @LeetCodeSolution
    public int solution2(int[] nums){
        if(nums.length < 2){
            return 0;
        }
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }

        int size = Math.max(1,(max - min) / (n - 1));
        int count = (max - min) / size  + 1;

        int[][] cache = new int[count][];
        for (int num : nums) {
            int index = (num - min) / size;
            if (cache[index] == null) {
                cache[index] = new int[2];
                cache[index][0] = num;
                cache[index][1] = num;
            } else {
                if (cache[index][0] > num) {
                    cache[index][0] = num;
                } else if (cache[index][1] < num) {
                    cache[index][1] = num;
                }
            }
        }
        int m = 0;
        int lastMax = min;
        for (int[] aCache : cache) {
            if (aCache != null) {
                if (aCache[0] - lastMax > m) {
                    m = aCache[0] - lastMax;
                }
                lastMax = aCache[1];
            }
        }
        return m;
    }
}
