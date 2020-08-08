package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目地址：https://leetcode-cn.com/problems/single-number-ii/
 * 题目：
 *     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *     说明：
 *     你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *     输入: [2,2,3,2]
 *     输出: 3
 *
 * 示例 2:
 *     输入: [0,1,0,1,0,1,99]
 *     输出: 99
 *
 */
public class L137SingleNumber extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int n: nums){
            if(map.get(n) == 1){
                return n;
            }
        }
        return 0;
    }

    @LeetCodeSolution
    public int solution2(int[] nums){
        int k = 0;
        for(int i = 0; i < 32; i++){
            int t = 0;
            for(int n: nums){
                if((n & (1 << i)) != 0){
                    t++;
                }
            }
            if(t % 3 != 0){
                k += (1 << i);
            }
        }
        return k;
    }
}
