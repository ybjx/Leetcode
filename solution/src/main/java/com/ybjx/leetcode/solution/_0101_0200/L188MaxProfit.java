package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 题目：
 *     给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *     设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *     注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *     输入: [2,4,1], k = 2
 *     输出: 2
 *     解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * 示例 2:
 *     输入: [3,2,6,5,0,3], k = 2
 *     输出: 7
 *     解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *          随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
public class L188MaxProfit extends AbstractSolution {
    @LeetCodeSolution
    public int solution(int k, int[] prices){
        if(prices.length / 2 <= k){
            return getMax(prices);
        }
        else{
            return getMax(k, prices);
        }
    }

    private int getMax(int k, int[] prices){
        int[][][] dp = new int[prices.length][k + 1][2];
        for(int i = 0; i < prices.length; i++){
            for(int j = k; j >= 1; j--){
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                }
                else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[prices.length - 1][k][0];
    }

    private int getMax(int[] prices){
        if(prices.length == 0){
            return 0;
        }
        int value = 0;
        int host = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = value;
            value = Math.max(value, host + price);
            host = Math.max(host, temp - price);
        }
        return value;
    }
}
