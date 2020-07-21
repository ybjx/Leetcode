package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/merge-intervals/
 * 题目：
 *     给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *     输入: [[1,3],[2,6],[8,10],[15,18]]
 *     输出: [[1,6],[8,10],[15,18]]
 *     解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 *     输入: [[1,4],[4,5]]
 *     输出: [[1,5]]
 *     解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class L056MergeIntervals extends AbstractSolution {

    @LeetCodeSolution
    public int [][] solution(int [][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                }
                else if(o1[0] < o2[0]){
                    return -1;
                }
                else{
                    if(o1[1] > o2[1]){
                        return -1;
                    }
                    else if(o1[1] < o2[1]){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        });

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            if(i == 0){
                List<Integer> l = new ArrayList<>();
                l.add(intervals[i][0]);
                l.add(intervals[i][1]);
                list.add(l);
            }
            else{
                List<Integer> l = list.get(list.size() - 1);
                if(l.get(1) >= intervals[i][0]){
                    if(l.get(1) < intervals[i][1]){
                        l.remove(1);
                        l.add(intervals[i][1]);
                    }
                }
                else{
                    l = new ArrayList<>();
                    l.add(intervals[i][0]);
                    l.add(intervals[i][1]);
                    list.add(l);
                }
            }
        }

        int [][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            List<Integer> l = list.get(i);
            result[i][0] = l.get(0);
            result[i][1] = l.get(1);
        }
        return result;
    }
}
