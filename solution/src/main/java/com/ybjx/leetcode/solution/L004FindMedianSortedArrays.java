package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 题目：
 *     给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *     请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *     你可以假设 nums1 和 nums2 不会同时为空。
 * 示例1：
 *     nums1 = [1, 3]
 *     nums2 = [2]
 *     则中位数是 2.0
 * 示例2：
 *     nums1 = [1, 2]
 *     nums2 = [3，4]
 *     则中位数是 (2 + 3)/2 = 2.5
 * @author ybjx
 * @date 2019/3/24 16:00
 */
public class L004FindMedianSortedArrays extends AbstractSolution {

    @LeetCodeSolution
    public double solution(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int min = 0;
        int max = len1;
        int v = (len1 + len2 + 1) / 2;
        int i,j,left,right;
        while(min <= max){
            i = (min + max) / 2;
            j = v - i;
            if(i < max && nums2[j - 1] > nums1[i]){
                min = i + 1;
            }else if(i > min && nums2[j] < nums1[i - 1]){
                max = i - 1;
            }
            else{
                if(i == 0){
                    left = nums2[j - 1];
                }
                else if(j == 0){
                    left = nums1[i - 1];
                }
                else{
                    left = nums1[i - 1] > nums2[j - 1]?nums1[i - 1]:nums2[j - 1];
                }
                if((len1 + len2) % 2 == 1){
                    return left;
                }
                if(i == len1){
                    right = nums2[j];
                }
                else if(j == len2){
                    right = nums1[i];
                }
                else{
                    right = nums1[i]>nums2[j]?nums2[j]:nums1[i];
                }
                return (left + right) / 2.0;
            }
        }
        return 0.0;
    }
}
