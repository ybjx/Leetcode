package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/wildcard-matching/
 * 题目：
 *      给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *      '?' 可以匹配任何单个字符。
 *      '*' 可以匹配任意字符串（包括空字符串）。
 *      两个字符串完全匹配才算匹配成功。
 * 说明:
 *      s 可能为空，且只包含从 a-z 的小写字母。
 *      p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * 示例 1:
 *      输入:
 *          s = "aa"
 *          p = "a"
 *      输出: false
 *      解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 *      输入:
 *          s = "aa"
 *          p = "*"
 *      输出: true
 *      解释: '*' 可以匹配任意字符串。
 *
 * 示例 3:
 *      输入:
 *          s = "cb"
 *          p = "?a"
 *      输出: false
 *      解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 * 示例 4:
 *      输入:
 *          s = "adceb"
 *          p = "*a*b"
 *      输出: true
 *      解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 *
 * 示例 5:
 *      输入:
 *          s = "acdcb"
 *          p = "a*c?b"
 *      输出: false
 */
public class L044IsMatch extends AbstractSolution{

    @LeetCodeSolution
    public boolean solution(String s, String p){
        List<String> keys = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int last = -1;
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            if(builder.length() == 0){
                if(c == '*' || c == '?'){
                    last = 1;
                }
                else {
                    last = 2;
                }
                builder.append(c);
                continue;
            }
            if(c == '*' || c == '?'){
                if(last == 2){
                    keys.add(builder.toString());
                    builder = new StringBuilder();
                    last = 1;
                }
                if(c == '?' || builder.indexOf("*") < 0){
                    builder.append(c);
                }
            }
            else{
                if(last == 1){
                    keys.add(builder.toString());
                    builder = new StringBuilder();
                    last = 2;
                }
                builder.append(c);
            }
        }
        if(last != -1){
            keys.add(builder.toString());
        }
        return check(s, keys);
    }

    private boolean check(String s, List<String> keys){
        if(keys.size() == 0){
            return s.length() == 0;
        }
        if(!keys.get(0).contains("*") && !keys.get(0).contains("?")){
            if(s.startsWith(keys.get(0))){
                return check(s.substring(keys.get(0).length()), keys.subList(1, keys.size()));
            }
            else{
                return false;
            }
        }
        else if(!keys.get(keys.size() - 1).contains("*") && !keys.get(keys.size() - 1).contains("?")){
            if(s.endsWith(keys.get(keys.size() - 1))){
                return check(s.substring(0, s.length() - keys.get(keys.size() - 1).length()), keys.subList(0, keys.size() - 1));
            }
            else{
                return false;
            }
        }

        int index = (keys.size() - 1)/ 2;
        String key = keys.get(index);
        if(key.contains("*") || key.contains("?")){
            index ++;
            if(index >= keys.size()){
                index = -1;
            }
            else{
                key = keys.get(index);
            }
        }

        if(index >= 0){
            int lastIndex = -1;
            for(int i = 0; i < index; i++){
                String k = keys.get(i);
                if(k.contains("*")){
                    lastIndex += (k.length() - 1);
                }
                else{
                    lastIndex += k.length();
                }
            }
            int rightIndex = 0;
            for(int i = index + 1; i < keys.size(); i++){
                String k = keys.get(i);
                if(k.contains("*")){
                    rightIndex += (k.length() - 1);
                }
                else{
                    rightIndex += k.length();
                }
            }
            while (true){
                lastIndex = s.indexOf(key, lastIndex + 1);
                if(lastIndex < 0 || lastIndex > (s.length() - rightIndex)){
                    return false;
                }
                else{
                    if(check(s.substring(0, lastIndex), keys.subList(0, index))
                            && check(s.substring(lastIndex + key.length()), keys.subList(index + 1, keys.size()))
                            ){
                        return true;
                    }
                }
            }
        }
        else{
            if(key.contains("*")){
                return s.length() >= key.length() - 1;
            }
            else{
                return s.length() == key.length();
            }
        }
    }
}
