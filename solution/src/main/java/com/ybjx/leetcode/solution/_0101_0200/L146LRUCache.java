package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目地址：https://leetcode-cn.com/problems/lru-cache/
 * 题目：
 *     运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *     获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 *     写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class L146LRUCache extends AbstractSolution {

    @LeetCodeSolution
    public void solution(){
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        Assert.assertEquals(-1,cache.get(1));
        Assert.assertEquals(3,cache.get(2));
    }

    class LRUCache {
        Map<Integer, Integer> cache = new HashMap<>();
        List<Integer> keyList = new ArrayList<>();
        int capacity;
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(cache.containsKey(key)){
                keyList.remove(keyList.indexOf(key));
                keyList.add(0, key);
                return cache.get(key);
            }
            else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(!cache.containsKey(key)){
                keyList.add(0, key);
            }
            else{
                keyList.remove(keyList.indexOf(key));
                keyList.add(0, key);
            }
            cache.put(key, value);
            if(cache.size() > capacity){
                cache.remove(keyList.get(keyList.size() - 1));
                keyList.remove(keyList.size() - 1);
            }
        }
    }
}
