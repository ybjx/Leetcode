package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/word-break-ii/
 * 题目：
 *     给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 *     分隔时可以重复使用字典中的单词。
 *     你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 *     输入:
 *       s = "catsanddog"
 *       wordDict = ["cat", "cats", "and", "sand", "dog"]
 *     输出:
 *       [
 *         "cats and dog",
 *         "cat sand dog"
 *       ]
 *
 * 示例 2：
 *     输入:
 *       s = "pineapplepenapple"
 *       wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 *     输出:
 *       [
 *         "pine apple pen apple",
 *         "pineapple pen apple",
 *         "pine applepen apple"
 *       ]
 *     解释: 注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 *     输入:
 *       s = "catsandog"
 *       wordDict = ["cats", "dog", "sand", "and", "cat"]
 *     输出:
 *       []
 */
public class L140WordBreak extends AbstractSolution {

    @LeetCodeSolution
    public List<String> solution(String s, List<String> wordDict){
        List<Integer> [] dp = new List[s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i] = new ArrayList<>();
            for(String w: wordDict){
                if(i + 1 - w.length() < 0){
                    continue;
                }
                if(s.substring(i + 1 - w.length(), i + 1).equals(w)){
                    if(i - w.length() < 0){
                        dp[i].add(-1);
                    }
                    else if(dp[i - w.length()].size() > 0){
                        dp[i].add(i - w.length());
                    }
                }
            }
        }
        return getString(dp, s.length() - 1, s);
    }

    private List<String> getString(List<Integer> [] dp, int index, String s){
        List<String> r = new ArrayList<>();
        for(Integer i: dp[index]){
            String str = s.substring(i + 1, index + 1);
            if(i == -1){
                r.add(str);
            }
            else{
                List<String> t = getString(dp, i, s);
                for(String k: t){
                    r.add(k + " " + str);
                }
            }
        }
        return r;
    }
}
