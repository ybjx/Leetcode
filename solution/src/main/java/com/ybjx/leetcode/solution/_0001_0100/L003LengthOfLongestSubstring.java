package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 题目：
 *     给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例1：
 *     输入: "abcabcbb"
 *     输出: 3
 *     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例2：
 *     输入: "bbbbb"
 *     输出: 1
 *     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例3：
 *     输入: "pwwkew"
 *     输出: 3
 *     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *           请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author ybjx
 * @date 2019/3/24 15:44
 */
public class L003LengthOfLongestSubstring extends AbstractSolution {

    @LeetCodeSolution(name="循环标记解法")
    public int solution(String s) {
        int [] temp = new int[256];
        int last = 0, result = 0;
        for(int i = 0; i < s.length(); i++){
            last = Math.max(last, temp[s.charAt(i)]);
            temp[s.charAt(i)] = i + 1;
            result =Math.max(result, i - last + 1);
        }
        return result;
    }
}
