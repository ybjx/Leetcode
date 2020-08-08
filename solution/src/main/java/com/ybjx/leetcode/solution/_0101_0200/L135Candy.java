package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/candy/
 * 题目：
 *     老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *     你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *     每个孩子至少分配到 1 个糖果。
 *     相邻的孩子中，评分高的孩子必须获得更多的糖果。
 *     那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *     输入: [1,0,2]
 *     输出: 5
 *     解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 *
 * 示例 2:
 *     输入: [1,2,2]
 *     输出: 4
 *     解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 */
public class L135Candy extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] ratings){
        if(ratings.length == 0){
            return 0;
        }
        int[] candy = new int[ratings.length];

        for(int i = 0; i < ratings.length; i++){
            if(i > 0 && ratings[i] > ratings[i - 1]){
                candy[i] = candy[i - 1] + 1;
            }
            else {
                candy[i] = 1;
                int k = i - 1;
                while (k >= 0) {
                    if(ratings[k] <= ratings[k + 1]){
                        if(ratings[k] < ratings[k + 1]){
                            candy[k + 1] = Math.max(candy[k], candy[k + 2]) + 1;
                        }
                        break;
                    }
                    candy[k] = candy[k + 1] + 1;
                    k--;
                }
            }
        }
        int t = 0;
        for (int aCandy : candy) {
            t += aCandy;
        }
        return t;
    }
}
