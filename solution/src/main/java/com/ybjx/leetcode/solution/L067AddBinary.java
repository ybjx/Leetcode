package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/add-binary/
 * 题目：
 *     给你两个二进制字符串，返回它们的和（用二进制表示）。
 *     输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *     输入: a = "11", b = "1"
 *     输出: "100"
 *
 * 示例 2:
 *     输入: a = "1010", b = "1011"
 *     输出: "10101"
 *
 * 提示：
 *     每个字符串仅由字符 '0' 或 '1' 组成。
 *     1 <= a.length, b.length <= 10^4
 *     字符串如果不是 "0" ，就都不含前导零。
 */
public class L067AddBinary extends AbstractSolution {

    @LeetCodeSolution
    public String solution(String a, String b){
        String s = calc(a, b, 0);
        if(s.length() == 0){
            return "0";
        }
        else{
            return s;
        }
    }

    private String calc(String a, String b, int c){
        if(a.length() == 0 && b.length() == 0){
            if(c == 0){
                return "";
            }
            else{
                return "1";
            }
        }
        int x = 0;
        int y = 0;
        if(a.length() > 0){
            x = (a.charAt(a.length() - 1) - '0');
            a = a.substring(0, a.length() - 1);
        }
        if(b.length() > 0){
            y = (b.charAt(b.length() - 1) - '0');
            b = b.substring(0, b.length() - 1);
        }
        c = x + y + c;
        return calc(a, b, c /2) + (c % 2 == 0 ? "0" : "1");
    }
}
