package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/interleaving-string/
 * 题目：
 *     给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1：
 *     输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 *     输出：true
 *
 * 示例 2：
 *     输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 *     输出：false
 */
public class L097IsInterleave extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean [][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                dp[i][j] = i == 0 && j == 0;
                if(j > 0){
                    if(dp[i][j - 1]){
                        dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    }
                }
                if(i > 0){
                    if(dp[i - 1][j]){
                        dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
