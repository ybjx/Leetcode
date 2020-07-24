package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.Stack;

/**
 * 题目地址：https://leetcode-cn.com/problems/valid-parentheses/submissions/
 * 题目：
 *     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *     有效字符串需满足：
 *         左括号必须用相同类型的右括号闭合。
 *         左括号必须以正确的顺序闭合。
 *         注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *     输入: "()"
 *     输出: true
 *
 * 示例 2:
 *     输入: "()[]{}"
 *     输出: true
 *
 * 示例 3:
 *     输入: "(]"
 *     输出: false
 *
 * 示例 4:
 *     输入: "([)]"
 *     输出: false
 *
 * 示例 5:
 *     输入: "{[]}"
 *     输出: true
 * @author ybjx
 * @date 2019/4/21 10:59
 */
public class L020IsValid extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution1(String s){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.size() == 0){
                    return false;
                }
                char t = stack.pop();
                if(c == ')' && t == '('){
                    continue;
                }
                if(c == ']' && t == '['){
                    continue;
                }
                if(c == '}' && t == '{'){
                    continue;
                }
                return false;
            }
        }
        return stack.size() == 0;
    }
}
