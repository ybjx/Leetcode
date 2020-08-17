package com.ybjx.leetcode.solution._0201_0300;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import org.junit.Assert;

/**
 * 题目地址：https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 题目：
 *     实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *     Trie trie = new Trie();
 *     trie.insert("apple");
 *     trie.search("apple");   // 返回 true
 *     trie.search("app");     // 返回 false
 *     trie.startsWith("app"); // 返回 true
 *     trie.insert("app");
 *     trie.search("app");     // 返回 true
 */
public class L208Trie extends AbstractSolution {

    @LeetCodeSolution
    public void solution(){
        Trie trie = new Trie();

        trie.insert("apple");
        Assert.assertEquals(true,trie.search("apple"));   // 返回 true
        Assert.assertEquals(false,trie.search("app"));     // 返回 false
        Assert.assertEquals(true,trie.startsWith("app")); // 返回 true
        trie.insert("app");
        Assert.assertEquals(true,trie.search("app"));     // 返回 true
    }

    class Trie {

        private Trie[] next = new Trie[26];

        private boolean isEnd = false;

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(word.length() == 0){
                isEnd = true;
                return;
            }
            int index = word.charAt(0) - 'a';
            if(next[index] == null){
                next[index] =new Trie();
            }
            next[index].insert(word.substring(1));
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if(word.length() == 0){
                return isEnd;
            }
            else{
                int index = word.charAt(0) - 'a';
                if(next[index] == null){
                    return false;
                }
                else{
                    return next[index].search(word.substring(1));
                }
            }
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if(prefix.length() == 0){
                return true;
            }
            else{
                int index = prefix.charAt(0) - 'a';
                if(next[index] == null){
                    return false;
                }
                else{
                    return next[index].startsWith(prefix.substring(1));
                }
            }
        }
    }
}
