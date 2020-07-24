package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：
 * 题目：
 *     给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 *     在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai)和 (i, 0)。
 *     找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：
 *     你不能倾斜容器，且 n 的值至少为 2。
 * 示例:
 *     输入: [1,8,6,2,5,4,8,3,7]
 *     输出: 49
 * @author ybjx
 * @date 2019/4/14 10:39
 */
public class L011MaxArea extends AbstractSolution {

    @LeetCodeSolution
    public int solution1(int[] height){
        int i, j;
        i = 0;
        j = height.length - 1;
        int  max = 0;
        while(i != j){
            int temp = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
            if(temp > max){
                max = temp;
            }
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }

    @LeetCodeSolution
    public int solution2(int[] height){
        int max = 0;
        int temp;
        int length = height.length;
        for(int i = 0; i < length - 1; i++){
            if(height[i] == 0){
                continue;
            }
            int w = max / height[i];
            int p = i + w + 1;
            for(int j = length - 1; j >= p; j--){
                temp = (height[i] > height[j] ? height[j]:height[i]) * (j - i);
                if(temp > max){
                    max = temp;
                    w = max / height[i];
                    p = i + w + 1;
                }
            }
        }
        return max;
    }
}
