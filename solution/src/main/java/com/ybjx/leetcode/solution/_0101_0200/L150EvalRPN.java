package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.Stack;

/**
 * 题目地址：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 题目：
 *     根据 逆波兰表示法，求表达式的值。
 *     有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *     整数除法只保留整数部分。
 *     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 *     输入: ["2", "1", "+", "3", "*"]
 *     输出: 9
 *     解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 示例 2：
 *     输入: ["4", "13", "5", "/", "+"]
 *     输出: 6
 *     解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * 示例 3：
 *     输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 *     输出: 22
 *     解释:
 *     该算式转化为常见的中缀算术表达式为：
 *     ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 *     = ((10 * (6 / (12 * -11))) + 17) + 5
 *     = ((10 * (6 / -132)) + 17) + 5
 *     = ((10 * 0) + 17) + 5
 *     = (0 + 17) + 5
 *     = 17 + 5
 *     = 22
 */
public class L150EvalRPN extends AbstractSolution {

    @LeetCodeSolution
    public int solution(String [] tokens){
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(stack.pop());
                switch (token) {
                    case "*":
                        stack.push(String.valueOf(x * y));
                        break;
                    case "/":
                        stack.push(String.valueOf(y / x));
                        break;
                    case "-":
                        stack.push(String.valueOf(y - x));
                        break;
                    default:
                        stack.push(String.valueOf(x + y));
                        break;
                }
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
