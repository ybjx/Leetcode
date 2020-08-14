package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import com.ybjx.leetcode.type.TreeNode;
import org.junit.Assert;

import java.util.Stack;

/**
 * 题目地址：https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * 题目：
 *     实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *     调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 示例：
 *     BSTIterator iterator = new BSTIterator(root);
 *     iterator.next();    // 返回 3
 *     iterator.next();    // 返回 7
 *     iterator.hasNext(); // 返回 true
 *     iterator.next();    // 返回 9
 *     iterator.hasNext(); // 返回 true
 *     iterator.next();    // 返回 15
 *     iterator.hasNext(); // 返回 true
 *     iterator.next();    // 返回 20
 *     iterator.hasNext(); // 返回 false
 */
public class L173BSTIterator extends AbstractSolution {

    @LeetCodeSolution
    public void solution(TreeNode root){
        BSTIterator iterator = new BSTIterator(root);
        Assert.assertEquals(3,iterator.next());    // 返回 3
        Assert.assertEquals(7, iterator.next());    // 返回 7
        Assert.assertEquals(true,iterator.hasNext()); // 返回 true
        Assert.assertEquals(9,iterator.next());    // 返回 9
        Assert.assertEquals(true,iterator.hasNext()); // 返回 true
        Assert.assertEquals(15,iterator.next());    // 返回 15
        Assert.assertEquals(true,iterator.hasNext()); // 返回 true
        Assert.assertEquals(20,iterator.next());    // 返回 20
        Assert.assertEquals(false,iterator.hasNext()); // 返回 false
    }

    class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            TreeNode p = root;
            while (p != null){
                stack.push(p);
                p = p.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode t = stack.peek();
            if(t.right != null){
                TreeNode p = t.right;
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
            }
            else{
                TreeNode p = stack.pop();
                while (stack.size() > 0) {
                    if(stack.peek().left == p){
                        break;
                    }
                    p = stack.pop();
                }
            }
            return t.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return stack.size() > 0;
        }
    }
}
