package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * 题目：
 *     给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *     返回符合要求的最少分割次数。
 *
 * 示例:
 *     输入: "aab"
 *     输出: 1
 *     解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 */
public class L132MinCut extends AbstractSolution {

    @LeetCodeSolution
    public int solution(String s){
        int n = s.length();
        char[] c = s.toCharArray();
        boolean [][] check = new boolean[n + 1][n + 1];
        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++){
            for(int j = i; j< n; j++){
                check[i + 1][j + 1] =  true;
                int l = i;
                int r = j;
                while (l < r){
                    if(c[l] != c[r]){
                        check[i + 1][j + 1] = false;
                        break;
                    }
                    l++;
                    r--;
                }
            }
        }
        dp[0] = -1;
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i - 1] + 1;
            for(int k = 1; k < i; k++){
                if(check[k][i]){
                    dp[i] = Math.min(dp[i], dp[k - 1] + 1);
                }
            }
        }
        return dp[n];
    }
}
