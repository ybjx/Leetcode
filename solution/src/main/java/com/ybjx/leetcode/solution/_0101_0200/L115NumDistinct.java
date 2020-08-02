package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/distinct-subsequences/
 * 题目：
 *     给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *     一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *     题目数据保证答案符合 32 位带符号整数范围。
 *
 * 示例 1：
 *     输入：S = "rabbbit", T = "rabbit"
 *     输出：3
 *     解释：
 *         如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 *         (上箭头符号 ^ 表示选取的字母)
 *             rabbbit
 *             ^^^^ ^^
 *             rabbbit
 *             ^^ ^^^^
 *             rabbbit
 *             ^^^ ^^^
 *
 * 示例 2：
 *     输入：S = "babgbag", T = "bag"
 *     输出：5
 *     解释：
 *         如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 *         (上箭头符号 ^ 表示选取的字母)
 *             babgbag
 *             ^^ ^
 *             babgbag
 *             ^^    ^
 *             babgbag
 *             ^    ^^
 *             babgbag
 *             ^  ^^
 *             babgbag
 *             ^^^

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/distinct-subsequences
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L115NumDistinct extends AbstractSolution{

    @LeetCodeSolution
    public int solution(String s, String t){
        if(t.length() == 0){
            return 1;
        }
        if(s.length() == 0){
            return 0;
        }
        int[][] dp = new int[t.length()][s.length()];
        for(int i = 0; i < t.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(t.charAt(i) == s.charAt(j)){
                    if(i > 0 && j > 0){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    if(i == 0){
                        dp[i][j] += 1;
                    }
                }
                if(j > 0){
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[t.length() - 1][s.length() - 1];
    }
}
