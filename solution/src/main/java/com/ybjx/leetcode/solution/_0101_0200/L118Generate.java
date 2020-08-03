package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/pascals-triangle/
 * 题目：
 *     给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *     在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *     输入: 5
 *     输出:
 *     [
 *     [1],
 *     [1,1],
 *     [1,2,1],
 *     [1,3,3,1],
 *     [1,4,6,4,1]
 *     ]
 */
public class L118Generate extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            return result;
        }
        List<List<Integer>> list = solution(numRows - 1);
        if(list.size() == 0){
            List<Integer> l = new ArrayList<>();
            l.add(1);
            list.add(l);
        }
        else{
            List<Integer> l = list.get(list.size() - 1);
            List<Integer> t = new ArrayList<>();
            t.add(1);
            for(int i = 0; i < l.size() - 1; i++){
                t.add(l.get(i) + l.get(i + 1));
            }
            t.add(1);
            list.add(t);
        }
        return list;
    }
}
