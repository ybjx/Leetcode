package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目地址：https://leetcode-cn.com/problems/palindrome-partitioning/
 * 题目：
 *     给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *     返回 s 所有可能的分割方案。
 *
 * 示例:
 *     输入: "aab"
 *     输出:
 *       [
 *         ["aa","b"],
 *         ["a","a","b"]
 *       ]
 */
public class L131Partition extends AbstractSolution {

    @LeetCodeSolution
    public List<List<String>> solution(String s){
        List<List<String>> r = new ArrayList<>();
        if(s.length() == 0){
            r.add(new ArrayList<>());
            return r;
        }
        else if(s.length() == 1){
            List<String> l = new ArrayList<>();
            l.add(s);
            r.add(l);
            return r;
        }
        Set<String> set = new HashSet<>();
        List<List<String>> l = solution(s.substring(0, s.length() - 1));
        String last = s.substring(s.length() - 1);
        for(List<String> t: l){
            List<String> temp;
            if(isSame(t.get(t.size() - 1), last)){
                temp = new ArrayList<>(t.subList(0, t.size() - 1));
                temp.add(t.get(t.size() - 1) + last);
                if(!set.contains(temp.toString())){
                    r.add(temp);
                    set.add(temp.toString());
                }
            }
            if(t.size() > 1){
                if(isSame(t.get(t.size() - 2), last)){
                    temp = new ArrayList<>(t.subList(0, t.size() - 2));
                    if(t.get(t.size() - 2).length() > 1){
                        String s1 = t.get(t.size() - 2);
                        temp.add(s1.substring(0, s1.length() - 1));
                    }
                    temp.add(last + t.get(t.size() - 1) + last);
                    if(!set.contains(temp.toString())){
                        r.add(temp);
                        set.add(temp.toString());
                    }
                }
            }
            temp = new ArrayList<>(t);
            temp.add(last);
            if(!set.contains(temp.toString())){
                r.add(temp);
                set.add(temp.toString());
            }
        }
        return r;
    }

    private boolean isSame(String s1, String s2){
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(0)){
                return false;
            }
        }
        return true;
    }
}
