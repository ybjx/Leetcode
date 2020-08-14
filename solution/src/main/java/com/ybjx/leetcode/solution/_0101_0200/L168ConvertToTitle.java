package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/excel-sheet-column-title/
 * 题目：
 *     给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * 示例 1:
 *     输入: 1
 *     输出: "A"
 *
 * 示例 2:
 *     输入: 28
 *     输出: "AB"
 *
 * 示例 3:
 *     输入: 701
 *     输出: "ZY"
 */
public class L168ConvertToTitle extends AbstractSolution {

    @LeetCodeSolution
    public String solution(int n){
        StringBuilder b = new StringBuilder();
        n--;
        while (n >= 26){
            int k = n % 26;
            b.insert(0, (char)('A' + k));
            n = n / 26 - 1;
        }
        b.insert(0, (char)('A' + n));
        return b.toString();
    }
}
