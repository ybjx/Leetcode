package com.ybjx.leetcode.solution._0001_0100;

import com.ybjx.leetcode.annotation.JudgeMethod;
import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.common.LeetCodeException;

/**
 * 题目地址：https://leetcode-cn.com/problems/sort-colors/
 * 题目：
 *     给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *     此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 *     不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *     输入: [2,0,2,1,1,0]
 *     输出: [0,0,1,1,2,2]
 */
public class L075SortColors extends AbstractSolution {
    @JudgeMethod
    public void judge(int[] param, int[] result){
        for(int i = 0; i < param.length; i++){
            if (param[i] != result[i]) {
                throw new LeetCodeException("自定义结果校验不通过");
            }
        }
    }

    @LeetCodeSolution
    public void solution(int[] nums){
        int [] temp = new int[3];
        for(int i = 0; i < nums.length; i++){
            temp[nums[i]]++;
        }

        int c =0;
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i]; j++){
                nums[c + j] = i;
            }
            c += temp[i];
        }
    }

    @LeetCodeSolution
    public void solution2(int[] nums){
        int pr = -1;
        int pw = -1;
        int pb = -1;
        for(int i = 0; i <nums.length; i++){
            if(nums[i] == 0){
                pr++;
                int t = nums[i];
                nums[i] = nums[pr];
                nums[pr] = t;
            }
            if(nums[i] == 1){
                if(pw < 0){
                    pw = pr + 1;
                }
                else{
                    pw++;
                }
                int t = nums[i];
                nums[i] = nums[pw];
                nums[pw] = t;
            }
            if(nums[i] == 2){
                if(pb < 0){
                    if(pw < 0){
                        pb = pr + 1;
                    }
                    else {
                        pb = pw + 1;
                    }
                }
                else{
                    pb++;
                }
                int t = nums[i];
                nums[i] = nums[pb];
                nums[pb] = t;
            }
        }
    }
}
