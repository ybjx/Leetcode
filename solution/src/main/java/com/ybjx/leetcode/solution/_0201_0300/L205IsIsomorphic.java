package com.ybjx.leetcode.solution._0201_0300;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目地址：https://leetcode-cn.com/problems/isomorphic-strings/
 * 题目：
 *     给定两个字符串 s 和 t，判断它们是否是同构的。
 *     如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *     所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *     输入: s = "egg", t = "add"
 *     输出: true
 *
 * 示例 2:
 *     输入: s = "foo", t = "bar"
 *     输出: false
 *
 * 示例 3:
 *     输入: s = "paper", t = "title"
 *     输出: true
 */
public class L205IsIsomorphic extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(String s, String t){
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            String s1 = s.substring(i, i + 1);
            String t1 = t.substring(i, i + 1);
            if(map1.containsKey(s1) || map2.containsKey(t1)){
                if(!t1.equals(map1.get(s1))){
                    return false;
                }
                if(!s1.equals(map2.get(t1))){
                    return false;
                }
            }
            else{
                map1.put(s1, t1);
                map2.put(t1, s1);
            }
        }
        return true;
    }
}
