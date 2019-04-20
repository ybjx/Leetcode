package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ybjx
 * @date 2019/3/20 23:20
 */
public class L30FindSubstring extends AbstractSolution {

    @LeetCodeSolution
    public List<Integer> solution(String s, String [] words){
        return null;
    }

    private static void test(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10000; i++){
            list.add(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while(true){
            test();
            Thread.sleep(1000);
        }
    }
}
