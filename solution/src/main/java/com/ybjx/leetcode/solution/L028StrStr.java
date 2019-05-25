package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/implement-strstr/
 * 题目：
 *      实现 strStr() 函数。
 *      给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 提示1：
 *      输入: haystack = "hello", needle = "ll"
 *      输出: 2
 *示例 2:
 *      输入: haystack = "aaaaa", needle = "bba"
 *      输出: -1
 *
 * @author ybjx
 * @date 2019/3/19 23:23
 */
public class L028StrStr extends AbstractSolution {

    @LeetCodeSolution
    public int solution1(String haystack, String needle){
        if(needle.length() > haystack.length()){
            return -1;
        }
        int result = -1;
        int index = 0;
        int end = haystack.length() - needle.length();
        while(index <= end){
            boolean found = true;
            for(int i = 0; i < needle.length(); i++){
                if(needle.charAt(i) != haystack.charAt(index + i)){
                    found = false;
                    break;
                }
            }
            if(found){
                result = index;
                break;
            }
            index ++;
        }
        return result;
    }

    @LeetCodeSolution
    public int solution2(String haystack, String needle){
        int index = 0;
        int end = haystack.length() - needle.length();
        while(index <= end){
            if(haystack.substring(index, index + needle.length()).equals(needle)){
                return index;
            }
            index ++;
        }
        return -1;
    }

    @LeetCodeSolution
    public int solution3(String haystack, String needle){
        if(needle.length() > haystack.length()){
            return -1;
        }
        int hashCode1 = 0;
        int hashCode2 = 0;
        for(int i = 0; i < needle.length(); i++){
            hashCode2 += needle.charAt(i);
            hashCode1 += haystack.charAt(i);
        }
        int index = 0;
        int end = haystack.length() - needle.length();
        while(index <= end){
            if(hashCode1 == hashCode2){
                if(haystack.substring(index, index + needle.length()).equals(needle)){
                    return index;
                }
            }
            if(index < end) {
                hashCode1 -= haystack.charAt(index);
                hashCode1 += haystack.charAt(index + needle.length());
            }
            index ++;
        }
        return -1;
    }

}
