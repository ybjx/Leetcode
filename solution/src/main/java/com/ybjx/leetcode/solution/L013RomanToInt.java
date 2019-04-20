package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目地址：https://leetcode-cn.com/problems/roman-to-integer/
 * 题目：
 *     给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *     输入: "III"
 *     输出: 3
 *
 * 示例 2:
 *     输入: "IV"
 *     输出: 4
 *
 * 示例 3:
 *     输入: "IX"
 *     输出: 9
 *
 * 示例 4:
 *     输入: "LVIII"
 *     输出: 58
 *     解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 *     输入: "MCMXCIV"
 *     输出: 1994
 *     解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @author ybjx
 * @date 2019/4/20 13:41
 */
public class L013RomanToInt extends AbstractSolution {
    @LeetCodeSolution
    public int solution(String s){
        Map<String, Integer> map = new HashMap<String, Integer>(16);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int result = 0;
        int len = s.length();
        int last = 0;
        for(int i = len -1; i >= 0; i--){
            int temp = map.get(s.substring(i, i + 1));
            if(temp < last){
                result -= temp;
            }
            else{
                result += temp;
                last = temp;
            }
        }
        return result;
    }
}
