package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/insert-interval/
 * 题目：
 *     给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *     在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *     输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 *     输出: [[1,5],[6,9]]
 *
 * 示例 2:
 *     输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 *     输出: [[1,2],[3,10],[12,16]]
 *     解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class L057InsertInterval extends AbstractSolution {

    @LeetCodeSolution
    public int[][] solution(int[][] intervals, int[] newInterval){
        if(newInterval.length == 0){
            return intervals;
        }
        boolean add = false;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l;
        for(int i = 0; i < intervals.length; i++){
            if((newInterval[0] <= intervals[i][1]) && !add){
                l = new ArrayList<>();
                l.add(newInterval[0] < intervals[i][0] ? newInterval[0] : intervals[i][0]);
                l.add(newInterval[1]);
                list.add(l);
                add = true;
            }
            if(list.size() == 0){
                l = new ArrayList<>();
                l.add(intervals[i][0]);
                l.add(intervals[i][1]);
                list.add(l);
            }
            else{
                l =list.get(list.size() - 1);
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
        if(!add){
            l = new ArrayList<>();
            l.add(newInterval[0]);
            l.add(newInterval[1]);
            list.add(l);
        }
        int [][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            l = list.get(i);
            result[i][0] = l.get(0);
            result[i][1] = l.get(1);
        }
        return result;

    }
}
