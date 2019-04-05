package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/zigzag-conversion/
 * 题目：
 *     将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *     比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *       L   C   I   R
 *       E T O E S I I G
 *       E   D   H   N
 *     之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *     请你实现这个将字符串进行指定行数变换的函数：
 *       string convert(string s, int numRows);
 *
 * 示例 1:
 *     输入: s = "LEETCODEISHIRING", numRows = 3
 *     输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 *     输入: s = "LEETCODEISHIRING", numRows = 4
 *     输出: "LDREOEIIECIHNTSG"
 *     解释:
 *       L     D     R
 *       E   O E   I I
 *       E C   I H   N
 *       T     S     G
 */
public class L006Convert extends AbstractSolution {

    @LeetCodeSolution
    public String solution(String s, int numRows){
        if(s.length() <= numRows || numRows == 1){
            return s;
        }
        StringBuilder builder = new StringBuilder();

        int count = numRows * 2 - 2;
        int n = s.length() / count + 1;
        int len = s.length();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < n; j++) {
                if(i + j * count >= len){
                    break;
                }
                builder.append(s.charAt(i + j * count));
                if(i > 0 && i < numRows - 1){
                    if(2 * numRows -i - 2 + j * count >= len){
                        break;
                    }
                    builder.append(s.charAt(2 * numRows -i - 2 + j * count));
                }
            }
        }
        return builder.toString();
    }
}
