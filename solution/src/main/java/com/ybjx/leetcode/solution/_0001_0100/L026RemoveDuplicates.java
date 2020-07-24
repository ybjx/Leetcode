package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 题目：
 *      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 *      给定数组 nums = [1,1,2],
 *      函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 *      给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *      函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 * @author ybjx
 * @date 2019/3/19 23:51
 */
public class L026RemoveDuplicates extends AbstractSolution {

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
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = 0;
        int p = 1;
        while(p < nums.length){
            if(nums[p] != nums[len]){
                len ++;
                nums[len] = nums[p];
            }
            p ++;
        }
        return len + 1;
    }
}
