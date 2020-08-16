package com.ybjx.leetcode.solution._0201_0300;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目地址：https://leetcode-cn.com/problems/happy-number/
 * 题目：
 *     编写一个算法来判断一个数 n 是不是快乐数。
 *     「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 *     然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *     如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 示例：
 *     输入：19
 *     输出：true
 *     解释：
 *       12 + 92 = 82
 *       82 + 22 = 68
 *       62 + 82 = 100
 *       12 + 02 + 02 = 1
 */
public class L202IsHappy extends AbstractSolution {

    Set<String> set = new HashSet<>();
    @LeetCodeSolution
    public boolean solution(int n){
        String s = String.valueOf(n);
        s = s.replaceAll("0", "");
        return isHappy(s);
    }

    private boolean isHappy(String s){
        if(s.equals("1")){
            return true;
        }
        if(set.contains(s)){
            return false;
        }
        set.add(s);
        int t = 0;
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - '0';
            t += (c * c);
        }
        String s1 = String.valueOf(t);
        s1 = s1.replaceAll("0", "");
        return isHappy(s1);
    }
}
