package com.wut.learn.CodeExam.NetEase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/20/15:39
 * @Description:
 */

import java.util.LinkedHashMap;
import java.util.Map;
public class LRUCache {
    /**
     * LRU缓存实现
     * 时间复杂度O(1)
     * 为了增强并发性能保证数据一致性
     * 1. 使用ConcurrentHashMap
     * 2. 使用ReentrantReadWriteLock 只允许一个线程写入 允许多个线程读取
     * 3. 如果并发是主要考虑的因素 考虑使用redis和Memcached
     * 4. 使用乐观锁
     */
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); //返回1
        cache.put(3, 3); //删除key 2
        System.out.println(cache.get(2)); // 返回-1 (未找到)
        cache.put(4, 4); //删除key 1
        System.out.println(cache.get(1)); //返回-1 (未找到)
        System.out.println(cache.get(3)); //返回3
        System.out.println(cache.get(4)); //返回4

    }
}