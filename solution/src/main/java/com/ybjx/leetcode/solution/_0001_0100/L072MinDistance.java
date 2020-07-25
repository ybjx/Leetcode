package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/edit-distance/
 * 题目：
 *     给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *     你可以对一个单词进行如下三种操作：
 *       1、插入一个字符
 *       2、删除一个字符
 *       3、替换一个字符
 *
 * 示例 1：
 *     输入：word1 = "horse", word2 = "ros"
 *     输出：3
 *     解释：
 *       horse -> rorse (将 'h' 替换为 'r')
 *       rorse -> rose (删除 'r')
 *       rose -> ros (删除 'e')
 *
 * 示例 2：
 *     输入：word1 = "intention", word2 = "execution"
 *     输出：5
 *     解释：
 *       intention -> inention (删除 't')
 *       inention -> enention (将 'i' 替换为 'e')
 *       enention -> exention (将 'n' 替换为 'x')
 *       exention -> exection (将 'n' 替换为 'c')
 *       exection -> execution (插入 'u')
 */
public class L072MinDistance extends AbstractSolution {

    @LeetCodeSolution
    public int solution(String word1, String word2){
        int [][] temp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    temp[i][j] = temp[i][j - 1] + 1;
                    continue;
                }
                if(j == 0){
                    temp[i][j] = temp[i - 1][j] + 1;
                    continue;
                }
                int min = temp[i - 1][j - 1];
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    min += 1;
                }
                if(min > temp[i - 1][j] + 1){
                    min = temp[i - 1][j] + 1;
                }
                if(min > temp[i][j - 1] + 1){
                    min = temp[i][j - 1] + 1;
                }
                temp[i][j] = min;
            }
        }
        return temp[word1.length()][word2.length()];
    }
}
