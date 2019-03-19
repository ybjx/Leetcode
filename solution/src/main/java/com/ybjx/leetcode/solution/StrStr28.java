package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * @author ybjx
 * @date 2019/3/19 23:23
 */
public class StrStr28 extends AbstractSolution {

    @LeetCodeSolution
    public int solution(String haystack, String needle){
        if(needle.length() > haystack.length()){
            return -1;
        }
        int result = -1;
        int index = 0;
        int end = haystack.length() - needle.length();
        while(index <= end){
            boolean found = true;
            for(int i = 0; i < needle.length(); i++){
                if(needle.charAt(i) != haystack.charAt(index + i)){
                    found = false;
                    break;
                }
            }
            if(found){
                result = index;
                break;
            }
            index ++;
        }
        return result;
    }
}
