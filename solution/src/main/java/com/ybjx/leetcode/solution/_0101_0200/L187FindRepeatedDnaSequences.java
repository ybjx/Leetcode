package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/repeated-dna-sequences/
 * 题目：
 *     所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *     编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 * 示例：
 *     输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *     输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class L187FindRepeatedDnaSequences extends AbstractSolution {

    @LeetCodeSolution
    public List<String> solution(String s){
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < s.length() - 9; i++){
            String t = s.substring(i, i + 10);
            if(!set.contains(t)){
                set.add(t);
            }
            else{
                if(!result.contains(t)) {
                    result.add(t);
                }
            }
        }
        return result;
    }
}
