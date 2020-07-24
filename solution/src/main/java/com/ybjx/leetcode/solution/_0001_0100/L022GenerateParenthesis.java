package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/generate-parentheses/submissions/
 * 题目：
 *     给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 示例：
 *     给出 n = 3，生成结果为：
 *     [
 *       "((()))",
 *       "(()())",
 *       "(())()",
 *       "()(())",
 *       "()()()"
 *     ]
 * @author ybjx
 * @date 2019/4/21 12:02
 */
public class L022GenerateParenthesis extends AbstractSolution {

    private static void makeString(List<String> result, String str, int pos, int n){
        if(pos == n){
            Stack<Integer> stack = new Stack<Integer>();
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '('){
                    stack.push(1);
                }
                else{
                    if(stack.size() == 0){
                        return;
                    }
                    stack.pop();
                }
            }
            if(stack.size() == 0){
                result.add(str);
            }
        }
        else{
            makeString(result, str + "(", pos + 1, n);
            makeString(result, str + ")", pos + 1, n);
        }
    }

    @LeetCodeSolution
    public List<String> solution1(int n){
        List<String> list = new ArrayList<String>();
        makeString(list, "", 0, n * 2);
        return list;
    }

    @LeetCodeSolution
    public List<String> solution2(int n){
        if(n == 0){
            return new ArrayList<String>();
        }
        else if(n == 1){
            List<String> list = new ArrayList<String>();
            list.add("()");
            return list;
        }
        List<String> list = solution2(n - 1);
        Set<String> set = new HashSet<String>();
        for(String str: list){
            set.add("()" + str);
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '('){
                    set.add(str.substring(0, i + 1) + "()" + str.substring(i + 1));
                }
            }
        }
        return new ArrayList<>(set);
    }
}
