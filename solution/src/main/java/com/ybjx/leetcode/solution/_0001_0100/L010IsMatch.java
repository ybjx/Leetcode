package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/regular-expression-matching/
 * 题目：
 *     给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *     '.' 匹配任意单个字符。
 *     '*' 匹配零个或多个前面的元素。
 *     匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * 说明:
 *     s 可能为空，且只包含从 a-z 的小写字母。
 *     p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *     输入:
 *         s = "aa"
 *         p = "a"
 *     输出: false
 *     解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *     输入:
 *         s = "aa"
 *         p = "a*"
 *     输出: true
 *     解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 *     输入:
 *         s = "ab"
 *         p = ".*"
 *     输出: true
 *     解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 *     输入:
 *         s = "aab"
 *         p = "c*a*b"
 *     输出: true
 *     解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *     输入:
 *         s = "mississippi"
 *         p = "mis*is*p*."
 *     输出: false
 * @author ybjx
 * @date 2019/4/14 10:28
 */
public class L010IsMatch extends AbstractSolution {
    public static boolean check(String s, String p, int sIndex, int pIndex){
        if(s.length() == sIndex && p.length() == pIndex){
            return true;
        }
        if(p.length() == pIndex){
            return false;
        }
        char pc = p.charAt(pIndex);
        if(s.length() == sIndex){
            if(pc == '+' || (pc >= 'A' && pc <= 'Z')){
                return check(s, p, sIndex, pIndex + 1);
            }
            else{
                return false;
            }
        }
        else{
            char sc = s.charAt(sIndex);
            if(sc == pc || pc == '.'){
                return check(s, p, sIndex + 1, pIndex + 1);
            }
            else if(sc == pc + 32 || pc == '+'){
                if(check(s, p, sIndex + 1, pIndex)){
                    return true;
                }
                else{
                    if(check(s, p, sIndex + 1, pIndex + 1)){
                        return true;
                    }
                    else{
                        return check(s, p, sIndex, pIndex+ 1);
                    }
                }
            }
            else{
                if(pc >= 'A' && pc <= 'Z'){
                    return check(s, p, sIndex, pIndex + 1);
                }
                else{
                    return false;
                }
            }
        }
    }

    @LeetCodeSolution
    public boolean solution(String s, String p){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) != '*'){
                builder.append(p.charAt(i));
            }
            else{
                if(i > 0){
                    char c = p.charAt(i - 1);
                    if(c == '.'){
                        builder.deleteCharAt(builder.length() - 1);
                        while(builder.length() > 0){
                            char ch = builder.charAt(builder.length() - 1);
                            if(ch == '+' || (ch >= 'A' && ch <= 'Z')){
                                builder.deleteCharAt(builder.length() - 1);
                            }
                            else{
                                break;
                            }
                        }
                        builder.append("+");
                    }
                    else if(c != '*'){
                        builder.deleteCharAt(builder.length() - 1);
                        if(builder.length() == 0 || (builder.charAt(builder.length() - 1) != (c - 32) && builder.charAt(builder.length() - 1) != '+')) {
                            builder.append((char) (c - 32));
                        }
                    }
                }
            }
        }

        return check(s, builder.toString(), 0,0);
    }
}
