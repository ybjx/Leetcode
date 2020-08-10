package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/max-points-on-a-line/
 * 题目：
 *     给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 示例 1:
 *     输入: [[1,1],[2,2],[3,3]]
 *     输出: 3
 *     解释:
 *     ^
 *     |
 *     |        o
 *     |     o
 *     |  o  
 *     +------------->
 *     0  1  2  3  4
 *
 * 示例 2:
 *     输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 *     输出: 4
 *     解释:
 *     ^
 *     |
 *     |  o
 *     |     o        o
 *     |        o
 *     |  o        o
 *     +------------------->
 *     0  1  2  3  4  5  6
 */
public class L149MaxPoints extends AbstractSolution {

    private int max = 0;

    private Map<String, List<Set<Integer>>> map = new HashMap<>();

    @LeetCodeSolution
    public int solution(int [][] points){
        max = 0;
        map.clear();
        if(points == null){
            return 0;
        }
        if(points.length <= 2){
            return points.length;
        }
        boolean same = true;
        for(int i = 1; i < points.length; i++){
            if(points[i - 1][0] != points[i][0] || points[i - 1][1] != points[i][1]){
                same = false;
                break;
            }
        }
        if(same){
            return points.length;
        }
        getMaxPoint(points, 0);
        return max;
    }

    private void getMaxPoint(int [][] points, int index){
        if(index >= points.length){
            return;
        }

        int[] p = points[index];

        for(int i = 0; i < index; i++){
            int [] p1 = points[i];
            String key = "";
            if(p1[0] == p[0] && p1[1] == p[1]){
                continue;
            }
            else if(p1[0] == p[0]){
                key = "max";
            }
            else if(p1[1] == p[1]){
                key = "0";
            }
            else{
                int a = gcb(p1[0] - p[0], p1[1] - p[1]);
                int x = (p1[0] - p[0])/a;
                int y = (p1[1] - p[1])/a;
                key = x + "_" + y;
            }
            List<Set<Integer>> list = map.get(key);
            if(list == null){
                list = new ArrayList<>();
                Set<Integer> l = new HashSet<>();
                l.add(i);
                l.add(index);
                list.add(l);
                if(l.size() > max){
                    max = l.size();
                }
                map.put(key, list);
            }
            else{
                List<Set<Integer>> temp = new ArrayList<>();
                Set<Integer> set = null;
                for(Set<Integer> s: list){
                    if(s.contains(i) || s.contains(index)){
                        if(set == null){
                            set = s;
                        }
                        else{
                            set.addAll(s);
                        }
                        set.add(i);
                        set.add(index);
                        if(set.size() > max){
                            max = set.size();
                        }
                        temp.add(set);
                    }
                    else{
                        temp.add(s);
                    }
                }
                if(set == null){
                    Set<Integer> l = new HashSet<>();
                    l.add(i);
                    l.add(index);
                    if(l.size() > max){
                        max = l.size();
                    }
                    list.add(l);
                }
            }
        }
        getMaxPoint(points, index + 1);
    }

    private int gcb(int a, int b){
        while (b != 0){
            a = a % b;
            int temp = b;
            b = a;
            a = temp;
        }
        return a;
    }
}
