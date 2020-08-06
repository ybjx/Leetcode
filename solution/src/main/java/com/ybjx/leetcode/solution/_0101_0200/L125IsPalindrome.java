package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/valid-palindrome/
 * 题目：
 *     给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *     说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *     输入: "A man, a plan, a canal: Panama"
 *     输出: true
 *
 * 示例 2:
 *     输入: "race a car"
 *     输出: false
 */
public class L125IsPalindrome extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            char l = s.charAt(i);
            char r = s.charAt(j);
            if(!((l >= '0' && l <='9') || (l >='a' && l <= 'z') || (l >='A' && l <='Z'))){
                i++;
                continue;
            }
            if(!((r >= '0' && r <='9') || (r >='a' && r <= 'z') || (r >='A' && r <='Z'))){
                j--;
                continue;
            }
            i++;
            j--;
            if(l == r){
                continue;
            }
            if(l > '9' && r > '9' && (l - r == 32 || r - l == 32)){
                continue;
            }
            return false;
        }
        return true;
    }
}
