package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.Arrays;

/**
 * 题目地址：https://leetcode-cn.com/problems/majority-element/
 * 题目：
 *     给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *     你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *     输入: [3,2,3]
 *     输出: 3
 *
 * 示例 2:
 *     输入: [2,2,1,1,1,2,2]
 *     输出: 2
 */
public class L169MajorityElement extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
