package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/
 * 题目：
 *     给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *     给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *     输入："23"
 *     输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *     
 * 说明:
 *     尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @author ybjx
 * @date 2019/4/21 10:05
 */
public class L017LetterCombinations extends AbstractSolution {

    @LeetCodeSolution
    public List<String> solution(String digits){
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return getString(letters, digits, 0);
    }

    private List<String> getString(String[] letters, String digits, int index){
        List<String> list = new ArrayList<String>();
        if(index >= digits.length()){
            return list;
        }
        int c = digits.charAt(index) - '0';
        if(c < 2 || c >= letters.length){
            return list;
        }
        List<String> l = getString(letters, digits, index + 1);
        for(int i = 0; i < letters[c].length(); i++){
            String str = letters[c].substring(i, i + 1);
            if(l.size() == 0){
                list.add(str);
            }
            else{
                for(String s: l){
                    list.add(str + s);
                }
            }
        }
        return list;
    }
}
