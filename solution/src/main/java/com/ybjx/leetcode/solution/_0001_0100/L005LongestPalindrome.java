package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 题目：
 *     给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例1：
 *     输入: "babad"
 *     输出: "bab"
 *     注意: "aba" 也是一个有效答案。
 * 示例2：
 *     输入: "cbbd"
 *     输出: "bb"
 * @author ybjx
 * @date 2019/3/31 20:34
 */
public class L005LongestPalindrome extends AbstractSolution {

    @LeetCodeSolution(name="暴力破解")
    public String solution1(String s){
        if(s.length() < 2){
            return s;
        }
        int len = s.length();
        String result = "";
        for(int i = 0; i < len; i++){
            String str = find(s, i, i);
            if(str.length() > result.length()){
                result = str;
            }
            if(i < len - 1) {
                str = find(s, i, i + 1);
                if (str.length() > result.length()) {
                    result = str;
                }
            }
        }
        return result;
    }

    private String find(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)){
                if(left + 1 <= right - 1){
                    return s.substring(left + 1, right);
                }
                else{
                    return "";
                }
            }
            left --;
            right ++;
        }
        return s.substring(left + 1, right);
    }

    @LeetCodeSolution(name = "动态规划")
    public String solution2(String s){
        if(s.length() < 2){
            return s;
        }
        boolean[][] temp = new boolean[s.length()][s.length()];
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j ++){
                temp[i][j] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || temp[i - 1][j + 1]));
                if(temp[i][j] && i - j > right - left){
                    left = j;
                    right = i;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    @LeetCodeSolution(name = "Manacher's Algorithm")
    public String solution3(String s){
        StringBuilder builder = new StringBuilder("%*");
        for(int i = 0; i < s.length(); i++){
            builder.append(s.charAt(i));
            builder.append("*");
        }
        int[] temp = new int[builder.length()];
        int lastIndex = 0;
        int lastMax = 0;
        int resultIndex = 0;
        int resultMax = 0;
        for(int i = 0; i < builder.length(); i++){
            temp[i] = lastMax > i ? (Math.min(temp[2 * lastIndex - i], lastMax - i)) : 1;
            while(i - temp[i] >= 0 && i + temp[i] < builder.length() && builder.charAt(i + temp[i]) == builder.charAt(i - temp[i])){
                temp[i] ++;
            }
            if(lastMax < i + temp[i]){
                lastIndex = i;
                lastMax = i + temp[i];
            }
            if(resultMax < temp[i]){
                resultMax = temp[i];
                resultIndex = i;
            }
        }
        int start = (resultIndex - resultMax)/2;
        int end = start + resultMax - 1;
        return s.substring(start, end);
    }
}
