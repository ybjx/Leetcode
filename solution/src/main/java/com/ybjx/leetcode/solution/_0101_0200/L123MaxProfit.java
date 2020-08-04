package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/comments/
 * 题目：
 *     给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *     设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *     注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *     输入: [3,3,5,0,0,3,1,4]
 *     输出: 6
 *     解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *          随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 示例 2:
 *     输入: [1,2,3,4,5]
 *     输出: 4
 *     解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *          注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *          因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 *     输入: [7,6,4,3,1]
 *     输出: 0
 *     解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class L123MaxProfit extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] prices){
        int m = prices.length;
        int [][] dp1 = new int[m][2];
        int [][] dp2 = new int[m][2];
        for(int i = 0; i < m; i++){
            if(i == 0){
                dp1[0][0] = prices[i];
                dp1[0][1] = 0;
            }
            else{
                dp1[i][0] = Math.min(dp1[i - 1][0], prices[i]);
                dp1[i][1] = Math.max(dp1[i - 1][1], prices[i] - dp1[i][0]);
            }
        }
        for(int i = m - 1; i >= 0; i--){
            if(i == m - 1){
                dp2[i][0] = prices[i];
                dp2[i][1] = 0;
            }
            else{
                dp2[i][0] = Math.max(dp2[i + 1][0], prices[i]);
                dp2[i][1] = Math.max(dp2[i + 1][1], dp2[i][0] - prices[i]);
            }
        }
        int max = 0;
        for(int i = 0; i < m; i++){
            if(i == 0){
                max = Math.max(max, dp2[i][1]);
            }
            else if(i == m - 1){
                max = Math.max(max, dp1[i][1]);
            }
            else{
                max = Math.max(max, dp1[i][1] + dp2[i + 1][1]);
            }
        }
        return max;
    }
}
