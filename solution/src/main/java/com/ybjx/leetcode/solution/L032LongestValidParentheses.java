package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.Stack;

/**
 * 题目地址：https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 题目：
 *      给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 *      输入: "(()"
 *      输出: 2
 *      解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 *      输入: ")()())"
 *      输出: 4
 *      解释: 最长有效括号子串为 "()()"
 * @author ybjx
 * @date 2019/5/25 15:31
 */
public class L032LongestValidParentheses extends AbstractSolution {

    @LeetCodeSolution
    public int solution1(String s){
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        int ret = 0;
        int start = -1;
        for(int i = 0; i < len; i++){
            char c= s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else{
                if(stack.size() == 0) {
                    start = i;
                }
                else{
                    stack.pop();
                    int temp = stack.size() == 0?start:stack.peek();
                    if(i - temp> ret){
                        ret = i - temp;
                    }
                }
            }
        }
        return ret;
    }

    @LeetCodeSolution
    public int solution2(String s){
        if(s.length() == 0){
            return 0;
        }
        int maxLen = 0;
        int[] list = new int[s.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            int j = i - list[i - 1] - 2;
            if(s.charAt(i -  1) == '(' || j < 0 || s.charAt(j) == ')'){
                list[i] = 0;
            }
            else{
                list[i] = list[i - 1] + list[j] + 2;
                maxLen = maxLen > list[i] ? maxLen : list[i];
            }
        }
        return maxLen;
    }
}
