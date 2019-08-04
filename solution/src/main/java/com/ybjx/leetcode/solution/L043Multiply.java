package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.Arrays;

/**
 * 题目地址：https://leetcode-cn.com/problems/multiply-strings/
 * 题目：
 *      给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *      输入: num1 = "2", num2 = "3"
 *      输出: "6"
 *
 * 示例 2:
 *      输入: num1 = "123", num2 = "456"
 *      输出: "56088"
 *
 * 说明：
 *      num1 和 num2 的长度小于110。
 *      num1 和 num2 只包含数字 0-9。
 *      num1 和 num2 均不以零开头，除非是数字 0 本身。
 *      不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author yubing
 * @date 2019-08-04 16:44
 */
public class L043Multiply extends AbstractSolution {

    @LeetCodeSolution
    public String solution(String num1, String num2){
        int len = num1.length() + num2.length();
        char[] result = new char[len];
        Arrays.fill(result, '0');
        for(int i = num1.length() - 1; i >= 0; i--){
            int n1 = num1.charAt(i) - '0';
            for(int j = num2.length() - 1; j >= 0; j--){
                int n2 = num2.charAt(j) - '0';
                int t = result[i + j + 1] - '0' + n1 * n2;
                result[i + j] += t / 10;
                result[i + j + 1] = (char)(t % 10 + '0');
            }
        }
        for(int i = 0; i < len; i++){
            if(result[i] != '0'){
                return new String(result, i, len - i);
            }
        }
        return "0";
    }
}
