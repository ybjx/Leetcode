package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/excel-sheet-column-number/
 * 题目：
 *     给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * 示例 1:
 *     输入: "A"
 *     输出: 1
 *
 * 示例 2:
 *     输入: "AB"
 *     输出: 28
 *
 * 示例 3:
 *     输入: "ZY"
 *     输出: 701
 */
public class L171TitleToNumber extends AbstractSolution {

    @LeetCodeSolution
    public int solution(String s){
        int r = 0;
        for(int i = 0; i < s.length(); i++){
            r = r * 26 + (s.charAt(i) - 'A' + 1);
        }
        return r;
    }
}
