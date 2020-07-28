package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/scramble-string/
 * 题目：
 *    给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 *    下图是字符串 s1 = "great" 的一种可能的表示形式。
 *        great
 *       /    \
 *      gr    eat
 *     / \    /  \
 *    g   r  e   at
 *   / \
 *  a   t
 *    在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 *    例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。

 *        rgeat
 *       /    \
 *      rg    eat
 *     / \    /  \
 *    r   g  e   at
 *   / \
 *  a   t
 *    我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 *    同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
 *        rgtae
 *       /    \
 *      rg    tae
 *     / \    /  \
 *    r   g  ta  e
 *   / \
 *  t   a
 *    我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 *    给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 *
 * 示例 1:
 *    输入: s1 = "great", s2 = "rgeat"
 *    输出: true
 *
 * 示例 2:
 *    输入: s1 = "abcde", s2 = "caebd"
 *    输出: false
 */
public class L087IsScramble extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(String s1, String s2){
        if(s1.equals(s2)){
            return true;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        int[] temp = new int[256];
        for(int i = 0; i < s1.length(); i++){
            temp[s1.charAt(i)] ++;
        }
        for(int i = 0; i < s1.length(); i++){
            temp[s2.charAt(i)] --;
            if(temp[s2.charAt(i)] < 0){
                return false;
            }
        }
        for(int i = 1; i < s2.length(); i++){
            String l1 = s1.substring(0, i);
            String r1 = s1.substring(i);
            String l2 = s2.substring(0, i);
            String r2 = s2.substring(i);
            if(solution(l1, l2) && solution(r1, r2)){
                return true;
            }
            l2 = s2.substring(0, s2.length() - i);
            r2 = s2.substring(s2.length() - i);
            if(solution(l1, r2) && solution(r1,l2)){
                return true;
            }
        }
        return false;
    }
}
