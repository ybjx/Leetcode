package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/pascals-triangle-ii/
 * 题目：
 *     给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *     在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *     输入: 3
 *     输出: [1,3,3,1]
 */
public class L119GetRow extends AbstractSolution {

    @LeetCodeSolution
    public List<Integer> solution(int rowIndex){
        if(rowIndex == -1){
            return new ArrayList<>();
        }

        List<Integer> list = solution(rowIndex - 1);
        if(list.size() == 0){
            list.add(1);
            return list;
        }
        else{
            List<Integer> r = new ArrayList<>();
            r.add(1);
            for(int i = 0; i < list.size() - 1; i++){
                r.add(list.get(i) + list.get(i + 1));
            }
            r.add(1);
            return r;
        }
    }
}
