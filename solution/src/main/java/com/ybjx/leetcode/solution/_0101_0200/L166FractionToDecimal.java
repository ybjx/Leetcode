package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目地址：https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 * 题目：
 *     给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *     如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *     输入: numerator = 1, denominator = 2
 *     输出: "0.5"
 *
 * 示例 2:
 *     输入: numerator = 2, denominator = 1
 *     输出: "2"
 *
 * 示例 3:
 *     输入: numerator = 2, denominator = 3
 *     输出: "0.(6)"
 */
public class L166FractionToDecimal extends AbstractSolution {

    @LeetCodeSolution
    public String solution(int numerator, int denominator){
        if(numerator == 0){
            return "0";
        }
        long n = (long)numerator;
        long d = (long)denominator;
        StringBuilder b = new StringBuilder();
        boolean sign = true;
        if(n < 0){
            n = -n;
            sign = false;
        }
        if(d < 0){
            d = -d;
            sign = !sign;
        }
        while (n >= d){
            b.append(n / d);
            n = n % d;
        }
        if(n != 0) {
            if(b.length() == 0){
                b.append("0.");
            }
            else{
                b.append(".");
            }
            Map<Long, Integer> map = new HashMap<>();
            while (n > 0) {
                if(map.containsKey(n)){
                    b.insert(map.get(n), "(");
                    b.append(")");
                    break;
                }
                map.put(n, b.length());
                n *= 10;
                b.append(n / d);
                n = n % d;
            }
        }
        if(!sign){
            b.insert(0, "-");
        }
        return b.toString();
    }
}
