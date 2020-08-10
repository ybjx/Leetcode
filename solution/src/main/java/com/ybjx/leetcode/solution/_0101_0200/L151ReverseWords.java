package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 题目：
 *     给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *     输入: "the sky is blue"
 *     输出: "blue is sky the"
 *
 * 示例 2：
 *     输入: "  hello world!  "
 *     输出: "world! hello"
 *     解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 *     输入: "a good   example"
 *     输出: "example good a"
 *     解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class L151ReverseWords extends AbstractSolution {

    @LeetCodeSolution
    public String solution(String s){
        String[] l = s.split(" ");

        StringBuilder b = new StringBuilder();
        for(int i = l.length - 1; i >= 0; i--){
            String t = l[i];
            if(t.length() == 0){
                continue;
            }
            b.append(t).append(" ");
        }
        if(b.length() > 0){
            b.replace(b.length() - 1, b.length(), "");
        }
        return b.toString();
    }
}
