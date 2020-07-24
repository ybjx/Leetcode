package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/valid-number/
 * 题目：
 *     验证给定的字符串是否可以解释为十进制数字。
 *
 * 例如:
 *     "0" => true
 *     " 0.1 " => true
 *     "abc" => false
 *     "1 a" => false
 *     "2e10" => true
 *     " -90e3   " => true
 *     " 1e" => false
 *     "e3" => false
 *     " 6e-1" => true
 *     " 99e2.5 " => false
 *     "53.5e93" => true
 *     " --6 " => false
 *     "-+3" => false
 *     "95a54e53" => false
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 *     数字 0-9
 *     指数 - "e"
 *     正/负号 - "+"/"-"
 *     小数点 - "."
 *     当然，在输入中，这些字符的上下文也很重要。
 */
public class L065IsNumber extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(String s){
        s = s.trim();
        if(s.length() == 0){
            return false;
        }
        return getNumberType(s, 0) > 0;
    }

    private int getNumberType(String s, int type){
        if(s.contains("e")){
            if(type > 0){
                return 0;
            }
            int index = s.indexOf("e");
            String s1 = s.substring(0, index);
            String s2 = s.substring(index + 1);
            if(getNumberType(s1, 1) > 0 && getNumberType(s2, 2) > 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        else if(s.startsWith("-") || s.startsWith("+")){
            if(type == 3 || type == 5){
                return 0;
            }
            return getNumberType(s.substring(1), 3);
        }
        else if(s.contains(".")){
            if(type == 2 ||  type == 5 || s.equals(".")){
                return 0;
            }
            int index = s.indexOf(".");
            String s1 = s.substring(0, index);
            String s2 = s.substring(index + 1);
            if((s1.length() == 0 || getNumberType(s1, 4) > 0 ) && (s2.length() == 0 || getNumberType(s2, 5) > 0)){
                return 1;
            }
            else{
                return 0;
            }
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c < '0' || c > '9'){
                return 0;
            }
        }
        return s.length();
    }
}
