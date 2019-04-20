package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.Arrays;

/**
 * 题目地址：https://leetcode-cn.com/problems/longest-common-prefix/
 * 题目：
 *     编写一个函数来查找字符串数组中的最长公共前缀。
 *     如果不存在公共前缀，返回空字符串 ""
 *
 * 示例 1:
 *     输入: ["flower","flow","flight"]
 *     输出: "fl"
 *
 * 示例 2:
 *     输入: ["dog","racecar","car"]
 *     输出: ""
 *     解释: 输入不存在公共前缀。
 * @author ybjx
 * @date 2019/4/20 13:50
 */
public class L014LongestCommonPrefix extends AbstractSolution {

    @LeetCodeSolution
    public String solution1(String[] strs){
        if(strs.length == 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while(true){
            char c = 0;
            for (String aList : strs) {
                if (index >= aList.length()) {
                    return builder.toString();
                }
                if (c == 0) {
                    c = aList.charAt(index);
                } else {
                    if (c != aList.charAt(index)) {
                        return builder.toString();
                    }
                }
            }
            index ++;
            builder.append(c);
        }
    }

    @LeetCodeSolution
    public String solution2(String[] strs){
        if(strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        int i = 0;
        while(i < strs[0].length()
                && strs[0].charAt(i) == strs[strs.length - 1].charAt(i)){
            i++;
        }
        return strs[0].substring(0, i);
    }
}
