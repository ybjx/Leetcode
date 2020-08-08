package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/word-break/
 * 题目：
 *     给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *     拆分时可以重复使用字典中的单词。
 *     你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 *     输入: s = "leetcode", wordDict = ["leet", "code"]
 *     输出: true
 *     解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 *     输入: s = "applepenapple", wordDict = ["apple", "pen"]
 *     输出: true
 *     解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *          注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 *     输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 *     输出: false
 */
public class L139WordBreak extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(String s, List<String> wordDict){
        boolean [] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            for(String w: wordDict){
                if(i + 1 - w.length() < 0){
                    continue;
                }
                if(s.substring(i + 1 - w.length(), i + 1).equals(w)){
                    if(i - w.length() < 0 || dp[i - w.length()]){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
