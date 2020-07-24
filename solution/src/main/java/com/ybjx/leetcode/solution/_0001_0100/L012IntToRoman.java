package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;


/**
 * 题目地址：https://leetcode-cn.com/problems/integer-to-roman/
 * 题目：
 *     给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * 示例 1:
 *     输入: 3
 *     输出: "III"
 *
 * 示例 2:
 *     输入: 4
 *     输出: "IV"
 *
 * 示例 3:
 *     输入: 9
 *     输出: "IX"
 *
 * 示例 4:
 *     输入: 58
 *     输出: "LVIII"
 *     解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 *     输入: 1994
 *     输出: "MCMXCIV"
 *     解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @author ybjx
 * @date 2019/4/20 13:21
 */
public class L012IntToRoman extends AbstractSolution {

    @LeetCodeSolution
    public String solution1(int num){
        StringBuilder builder = new StringBuilder();
        int temp = num / 1000;
        for(int i = 0; i < temp; i++){
            builder.append("M");
        }
        num = num % 1000;
        if(num >= 900){
            builder.append("CM");
            num -= 900;
        }
        else if(num >= 500){
            builder.append("D");
            num -= 500;
        }
        else if(num >= 400){
            num -= 400;
            builder.append("CD");
        }
        temp = num / 100;
        for(int i = 0; i < temp; i++){
            builder.append("C");
        }
        num = num % 100;
        if(num >= 90){
            builder.append("XC");
            num -= 90;
        }
        else if(num >= 50){
            builder.append("L");
            num -= 50;
        }
        else if(num >= 40){
            num -= 40;
            builder.append("XL");
        }
        temp = num / 10;
        for(int i = 0; i < temp; i++){
            builder.append("X");
        }
        temp = num % 10;
        if(temp == 9){
            builder.append("IX");
            temp -= 9;
        }
        else if(temp >=5){
            builder.append("V");
            temp -= 5;
        }
        else if(temp == 4){
            builder.append("IV");
            temp -= 4;
        }
        for(int i = 0; i < temp; i++){
            builder.append("I");
        }
        return builder.toString();
    }

    @LeetCodeSolution
    public String solution2(int num){
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] keys = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                result.append(keys[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }
}
