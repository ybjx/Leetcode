package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/group-anagrams/
 * 题目：
 *     给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *     输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 *
 * 输出:
 *     [
 *         ["ate","eat","tea"],
 *         ["nat","tan"],
 *         ["bat"]
 *     ]
 *
 * 说明：
 *     所有输入均为小写字母。
 *     不考虑答案输出的顺序。
 */
public class L049GroupAnagrams extends AbstractSolution {

    @LeetCodeSolution
    public List<List<String>> solution(String [] strs){
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char [] t = s.toCharArray();
            Arrays.sort(t);
            String str = new String(t);
            List<String> list = map.get(str);
            if(list == null){
                list = new ArrayList<>();
                map.put(str, list);
                result.add(list);
            }
            list.add(s);
        }
        return result;
    }
}
