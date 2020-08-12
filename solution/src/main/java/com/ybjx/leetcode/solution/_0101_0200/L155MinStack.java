package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/min-stack/
 * 题目：
 *     设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *     push(x) —— 将元素 x 推入栈中。
 *     pop() —— 删除栈顶的元素。
 *     top() —— 获取栈顶元素。
 *     getMin() —— 检索栈中的最小元素。
 */
public class L155MinStack extends AbstractSolution {

    @LeetCodeSolution
    public void solution(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3,minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0,minStack.top());
        Assert.assertEquals(-2, minStack.getMin());
    }

    class MinStack{
        List<Integer> sortList = new ArrayList<>();
        List<Integer> stackList = new ArrayList<>();

        public MinStack() {

        }

        public void push(int x) {
            stackList.add(x);
            int index = -1;
            for(int i = 0; i < sortList.size(); i++){
                if(sortList.get(i) > x){
                    index = i;
                    break;
                }
            }
            if(index >= 0){
                sortList.add(index, x);
            }
            else{
                sortList.add(x);
            }
        }

        public void pop() {
            int x = stackList.get(stackList.size() - 1);
            stackList.remove(stackList.size() - 1);
            sortList.remove(sortList.indexOf(x));

        }

        public int top() {
            return stackList.get(stackList.size() - 1);
        }

        public int getMin() {
            return sortList.get(0);
        }
    }
}
