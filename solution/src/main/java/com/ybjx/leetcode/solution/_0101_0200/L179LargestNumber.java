package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/largest-number/
 * 题目：
 *     给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *     输入: [10,2]
 *     输出: 210
 *
 * 示例 2:
 *     输入: [3,30,34,5,9]
 *     输出: 9534330
 *
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class L179LargestNumber extends AbstractSolution {

    @LeetCodeSolution
    public String solution(int[] nums){
        List<String> list = new ArrayList<>();
        for(int num: nums){
            list.add(String.valueOf(num));
        }

        list.sort((o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });
        if(list.size() > 0 && list.get(0).equals("0")){
            return "0";
        }
        StringBuilder b = new StringBuilder();
        for(String s: list){
            b.append(s);
        }
        return b.toString();
    }
}
