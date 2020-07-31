package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/decode-ways/submissions/
 * 题目：
 *     一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *       'A' -> 1
 *       'B' -> 2
 *       ...
 *       'Z' -> 26
 *     给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *     输入: "12"
 *     输出: 2
 *     解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2:
 *     输入: "226"
 *     输出: 3
 *     解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class L091NumDecodings extends AbstractSolution {

    @LeetCodeSolution
    public int solution(String s){
        if(s.length() == 0 || s.startsWith("0")){
            return 0;
        }
        if(s.length() < 3){
            int v = Integer.valueOf(s);
            if(v > 10 && v <= 26 && v!= 20){
                return 2;
            }
            else  if (v == 0){
                return 0;
            }
            else{
                if(v > 26 && v % 10 == 0){
                    return 0;
                }
                return 1;
            }
        }

        int k1 = s.length() / 2;
        int k2 = k1 + 1;

        int a = solution(s.substring(0, k1));
        int b = solution(s.substring(k1));
        int c = solution(s.substring(0, k2));
        int d = solution(s.substring(k2));
        int t= a * b + c * d;
        if(b > 0 && c > 0){
            t -= (a * d);
        }
        return t;
    }
}
