package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/palindrome-number/
 * 题目：
 *     判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 *     输入: 121
 *     输出: true
 * 示例 2:
 *     输入: -121
 *     输出: false
 *     解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *     输入: 10
 *     输出: false
 *     解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * @author ybjx
 * @date 2019/4/14 10:14
 */
public class L009IsPalindrome extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(int x){
        if(x < 0 || (x % 10 == 0  && x > 0)){
            return false;
        }
        int result = 0;
        int temp = x;
        while(temp > 0){
            result = result * 10 + (temp % 10);
            if(result == temp){
                return true;
            }
            temp = temp / 10;
            if(result == temp){
                return true;
            }
        }
        return result == x;
    }

}
