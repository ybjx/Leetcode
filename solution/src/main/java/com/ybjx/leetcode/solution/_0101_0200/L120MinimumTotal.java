package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/triangle/
 * 题目：
 *     给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *     相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 *       [
 *         [2],
 *         [3,4],
 *         [6,5,7],
 *         [4,1,8,3]
 *       ]
 *     自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class L120MinimumTotal extends AbstractSolution {

    @LeetCodeSolution
    public int solution(List<List<Integer>> triangle){
        if(triangle.size() == 0){
            return 0;
        }
        int [] temp=new int[triangle.size()];
        List<Integer> l = triangle.get(triangle.size() - 1);
        for(int i = 0; i < l.size(); i++){
            temp[i] = l.get(i);
        }
        for(int i = triangle.size() - 2; i >= 0; i--){
            l = triangle.get(i);
            for(int j = 0; j < l.size(); j++){
                temp[j] = l.get(j) + (temp[j] > temp[j + 1] ? temp[j + 1] : temp[j]);
            }
        }
        return temp[0];
    }
}
