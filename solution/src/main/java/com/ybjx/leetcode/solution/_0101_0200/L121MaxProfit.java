package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 题目：
 *     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *     如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *     注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *     输入: [7,1,5,3,6,4]
 *     输出: 5
 *     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *           注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2:
 *     输入: [7,6,4,3,1]
 *     输出: 0
 *     解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class L121MaxProfit extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] prices){
        int max = 0;
        int [] temp = new int[prices.length];
        for(int i = prices.length - 2; i >= 0; i--){
            if(temp[i + 1] > 0){
                if(prices[i] < temp[i + 1]){
                    temp[i] = temp[i + 1];
                }
            }
            else{
                if(prices[i] < prices[i + 1]){
                    temp[i] = prices[i + 1];
                }
            }
            if(temp[i] > 0 && temp[i] - prices[i] > max){
                max = temp[i] - prices[i];
            }
        }
        return max;
    }
}
