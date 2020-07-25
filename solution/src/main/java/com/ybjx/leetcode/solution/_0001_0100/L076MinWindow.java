package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/minimum-window-substring/
 * 题目：
 *     给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *     输入: S = "ADOBECODEBANC", T = "ABC"
 *     输出: "BANC"
 *
 * 说明：
 *     如果 S 中不存这样的子串，则返回空字符串 ""。
 *     如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class L076MinWindow extends AbstractSolution {

    @LeetCodeSolution
    public String solution(String s, String t){
        if(t.length() == 0){
            return "";
        }
        int[] temp = new int[256];
        int c = 0;
        for(int i = 0; i < t.length(); i++){
            temp[t.charAt(i)] ++;
            if(temp[t.charAt(i)] == 1){
                c++;
            }
        }
        return calc(s, temp, c, t.length());
    }

    private String calc(String s,int [] temp, int c, int width){
        if(s.length() < width){
            return "";
        }
        int [] t = new int[256];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char sc;
            if(i >= width){
                sc = s.charAt(i - width);
                if(temp[sc] > 0){
                    if(t[sc] == temp[sc]){
                        count --;
                    }
                    t[sc]--;
                }
            }
            sc = s.charAt(i);
            if(temp[sc] > 0){
                t[sc]++;
                if(temp[sc] == t[sc]){
                    count++;
                    if(count == c){
                        return s.substring(i - width + 1, i + 1);
                    }
                }
            }
        }
        return calc(s, temp, c, width + 1);
    }
}
