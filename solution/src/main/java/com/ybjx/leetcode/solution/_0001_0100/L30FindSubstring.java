package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * 题目：
 *      给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *      注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * 示例 1：
 *      输入：
 *          s = "barfoothefoobarman",
 *          words = ["foo","bar"]
 *      输出：[0,9]
 *      解释：
 *          从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 *          输出的顺序不重要, [9,0] 也是有效答案。
 *
 * 示例 2：
 *      输入：
 *          s = "wordgoodgoodgoodbestword",
 *          words = ["word","good","best","word"]
 *      输出：[]
 * @author ybjx
 * @date 2019/3/20 23:20
 */
public class L30FindSubstring extends AbstractSolution {


    private boolean check(String s, String[] words, int index){
        List<String> list = new ArrayList<>();
        int k = words[0].length();
        for (String word : words) {
            list.add(s.substring(index, index + k));
            index += k;
        }
        list.sort(Comparator.naturalOrder());
        for(int i = 0; i < words.length; i++){
            if(!words[i].equals(list.get(i))){
                return false;
            }
        }
        return true;
    }

    @LeetCodeSolution
    public List<Integer> solution1(String s, String [] words){
        List<Integer> result = new ArrayList<>();
        if(words.length == 0 || s.length() == 0){
            return result;
        }
        int k = s.length() - words.length * words[0].length();
        if(s.length() < k){
            return result;
        }
        Arrays.sort(words);
        for(int i = 0; i <= k; i++){
            if(check(s, words, i)){
                result.add(i);
            }
        }
        return result;
    }

    @LeetCodeSolution
    public List<Integer> solution2(String s, String[] words){
        List<Integer> result = new ArrayList<>();
        if(words.length == 0 || s.length() == 0){
            return result;
        }
        if(s.length() < words.length * words[0].length()){
            return result;
        }
        int k = s.length() - words.length * words[0].length();
        HashMap<String, Integer> cache = new HashMap<>(8);
        for(String str: words){
            cache.put(str, cache.getOrDefault(str, 0) + 1);
        }
        for(int i = 0; i <= k; i++){
            int m = words.length;
            HashMap<String, Integer> temp = new HashMap<>(cache);
            while(m > 0){
                String str = s.substring(i + (m - 1) * words[0].length(), i + m * words[0].length());
                Integer count = temp.get(str);
                if(count == null){
                    break;
                }
                if(count == 1){
                    temp.remove(str);
                }
                else{
                    temp.put(str, count - 1);
                }
                m--;
            }
            if(m == 0){
                result.add(i);
            }
        }
        return result;
    }

    @LeetCodeSolution
    public List<Integer> solution3(String s, String[] words){
        List<Integer> result = new ArrayList<>();
        if(words.length == 0 || s.length() == 0){
            return result;
        }
        int total = words.length * words[0].length();
        int k = words[0].length();
        if(s.length() < total){
            return result;
        }
        HashMap<String, Integer> cache = new HashMap<>(8);
        for(String str: words){
            cache.put(str, cache.getOrDefault(str, 0) + 1);
        }
        HashMap<String, Integer> temp = new HashMap<>(8);
        for(int i = 0; i <k; i++){
            int left = i;
            int right = i;
            temp.clear();
            while(left <= s.length() - total && right <= s.length() - k){
                String str = s.substring(right, right + k);
                if(!cache.containsKey(str)){
                    temp.clear();
                    left = right + k;
                    right = left;
                    continue;
                }
                temp.put(str, temp.getOrDefault(str, 0) + 1);
                while(temp.get(str) > cache.get(str)){
                    String lstr = s.substring(left, left + k);
                    temp.put(lstr, temp.getOrDefault(lstr, 1) - 1);
                    left += k;
                }
                right+= k;
                if(right - left == total){
                    result.add(left);
                }
            }
        }
        return result;
    }
}
