package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * 题目：
 *     给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *     给定 nums = [1,1,1,2,2,3],
 *     函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *     你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 *     给定 nums = [0,0,1,1,1,1,2,3,3],
 *     函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *     你不需要考虑数组中超出新长度后面的元素。
 */
public class L080RemoveDuplicates extends AbstractSolution {

    @JudgeMethod
    public void judge(int count, int[] param, int[] result){
        for(int i = 0; i < count; i++){
            if(param[i] != result[i]){
                throw new LeetCodeException("自定义结果校验不通过");
            }
        }
    }

    @LeetCodeSolution
    public int solution(int [] nums){
        int p = 0;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[p]){
                nums[p + 2] = nums[i];
                p++;
            }
        }
        return p + 2;
    }
}
