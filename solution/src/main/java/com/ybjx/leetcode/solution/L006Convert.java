package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

public class L006Convert extends AbstractSolution {

    @LeetCodeSolution
    public String solution(String s, int numRows){
        if(s.length() <= numRows || numRows == 1){
            return s;
        }
        StringBuilder builder = new StringBuilder();

        int count = numRows * 2 - 2;
        int n = s.length() / count + 1;
        int len = s.length();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < n; j++) {
                if(i + j * count >= len){
                    break;
                }
                builder.append(s.charAt(i + j * count));
                if(i > 0 && i < numRows - 1){
                    if(2 * numRows -i - 2 + j * count >= len){
                        break;
                    }
                    builder.append(s.charAt(2 * numRows -i - 2 + j * count));
                }
            }
        }
        return builder.toString();
    }
}
