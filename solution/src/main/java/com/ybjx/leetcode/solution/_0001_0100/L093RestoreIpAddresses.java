package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/restore-ip-addresses/
 * 题目：
 *     给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *     有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 * 示例:
 *     输入: "25525511135"
 *     输出: ["255.255.11.135", "255.255.111.35"]
 */
public class L093RestoreIpAddresses extends AbstractSolution {

    @LeetCodeSolution
    public List<String> solution(String s){
        return calc(s, 0);
    }

    private List<String> calc(String s, int index){
        List<String> list = new ArrayList<>();
        if(s.length() > 3 * (4 - index) || s.length() == 0){
            return list;
        }
        if(index == 3){
            if(s.length() > 1 && s.startsWith("0")){
                return new ArrayList<>();
            }
            int v = Integer.valueOf(s);
            if (v > 255) {
                return new ArrayList<>();
            } else {
                list.add(s);
                return list;
            }
        }
        List<String> temp;
        String t;
        if(s.length() > 1) {
            temp = calc(s.substring(1), index + 1);
            t = s.substring(0, 1);
            for (String str : temp) {
                list.add(t + "." + str);
            }
        }
        if(s.length() > 2 && !s.startsWith("0")) {
            temp = calc(s.substring(2), index + 1);
            t = s.substring(0, 2);
            for (String str : temp) {
                list.add(t + "." + str);
            }
        }
        if(s.length() > 3 && !s.startsWith("0")) {
            t = s.substring(0, 3);
            if (Integer.valueOf(t) <= 255) {
                temp = calc(s.substring(3), index + 1);
                for (String str : temp) {
                    list.add(t + "." + str);
                }
            }
        }
        return list;
    }
}
