package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/merge-sorted-array/
 * 题目：
 *     给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 *     初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 *     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 *     输入:
 *       nums1 = [1,2,3,0,0,0], m = 3
 *       nums2 = [2,5,6],       n = 3
 *     输出: [1,2,2,3,5,6]
 */
public class L088Merge extends AbstractSolution {

    @JudgeMethod
    public void check(int[] nums1, int m, int[] nums2, int n, int [] result){
        for(int i = 0; i < result.length; i++){
            if(result[i] != nums1[i]){
                throw new LeetCodeException("结果不正确");
            }
        }
    }

    @LeetCodeSolution
    public void solution(int[] nums1, int m, int[] nums2, int n){
        int p = m + n - 1;
        m--;
        n--;
        while (n >= 0){
            if(m >= 0 && nums1[m] > nums2[n]){
                nums1[p] = nums1[m];
                m--;
            }
            else{
                nums1[p] = nums2[n];
                n--;
            }
            p--;
        }
    }
}
