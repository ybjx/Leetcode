package com.ybjx.leetcode.solution._0201_0300;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/course-schedule/
 * 题目：
 *     你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *     在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *     给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *     输入: 2, [[1,0]]
 *     输出: true
 *     解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 *     输入: 2, [[1,0],[0,1]]
 *     输出: false
 *     解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 */
public class L207CanFinish extends AbstractSolution {

    @LeetCodeSolution
    public boolean solution(int numCourses, int[][] prerequisites){
        List<Integer> [] pre = new List[numCourses];
        List<Integer> [] next = new List[numCourses];
        for(int i = 0; i < numCourses; i++){
            pre[i] = new ArrayList<>();
            next[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            pre[prerequisite[0]].add(prerequisite[1]);
            next[prerequisite[1]].add(prerequisite[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(pre[i].size() == 0){
                update(pre, next, i);
            }
        }
        for(int i = 0; i < numCourses; i++){
            if(pre[i].size() > 0){
                return false;
            }
        }
        return true;
    }

    private void update(List<Integer> [] pre, List<Integer> [] next, int index){
        List<Integer> list = new ArrayList<>(next[index]);
        for(int i: list){
            pre[i].remove(pre[i].indexOf(index));
            next[index].remove(next[index].indexOf(i));
            if(pre[i].size() == 0){
                update(pre, next, i);
            }
        }

    }
}
