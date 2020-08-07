package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/word-ladder-ii/
 * 题目：
 *     给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *     每次转换只能改变一个字母。
 *     转换后得到的单词必须是字典中的单词。
 *
 * 说明:
 *     如果不存在这样的转换序列，返回一个空列表。
 *     所有单词具有相同的长度。
 *     所有单词只由小写字母组成。
 *     字典中不存在重复的单词。
 *     你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 *     输入:
 *       beginWord = "hit",
 *       endWord = "cog",
 *       wordList = ["hot","dot","dog","lot","log","cog"]
 *     输出:
 *       [
 *         ["hit","hot","dot","dog","cog"],
 *         ["hit","hot","lot","log","cog"]
 *       ]
 *
 * 示例 2:
 *     输入:
 *       beginWord = "hit"
 *       endWord = "cog"
 *       wordList = ["hot","dot","dog","lot","log"]
 *     输出: []
 *     解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
public class L126FindLadders extends AbstractSolution {


    private Map<String, List<String>> map = new HashMap<>();

    private Map<String, Integer> cache = new HashMap<>();

    @LeetCodeSolution
    public List<List<String>> solution(String beginWord, String endWord, List<String> wordList){
        if(beginWord.length() == 0){
            return new ArrayList<>();
        }
        wordList.add(0, beginWord);
        if(!wordList.contains(endWord)){
            return new ArrayList<>();
        }
        for(int i = 0; i < wordList.size(); i++){
            String s = wordList.get(i);
            cache.put(s, Integer.MAX_VALUE);
            if(s.equals(endWord)){
                continue;
            }
            List<String> l = new ArrayList<>();
            map.put(s, l);
            for(String s1: wordList){
                if(isOk(s, s1)){
                    l.add(s1);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add(beginWord);
        result.add(l);
        return calc(result, endWord);
    }

    private List<List<String>> calc(List<List<String>> list,  String endWord){
        List<List<String>> r = new ArrayList<>();
        for(List<String> l: list){
            if(l.contains(endWord)){
                r.add(l);
            }
        }
        if(r.size() > 0){
            return r;
        }
        for(List<String> l: list){
            List<String> t = map.get(l.get(l.size() - 1));
            if(t.size() == 0){
                continue;
            }
            for(String s: t){
                if(l.contains(s)){
                    continue;
                }
                if(cache.get(s) < l.size() + 1){
                    continue;
                }
                cache.put(s, l.size() + 1);
                List<String> ll = new ArrayList<>(l);
                ll.add(s);
                r.add(ll);
            }
        }
        if(r.size() == 0){
            return r;
        }
        else{
            return calc(r, endWord);
        }
    }

    private boolean isOk(String s1, String s2){
        int c = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                c++;
            }
        }
        return c == 1;
    }
}
