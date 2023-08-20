package com.wut.learn.CodeExam.NetEase;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/20/15:43
 * @Description:
 */
public class LRUCache2 {
    /**
     * LRU缓存实现
     */
    Map<Integer,Integer> map;
    int capacity;
    public LRUCache2(int capacity) {
        // write code here
        this.capacity = capacity;
        // LinkedHashMap可以保证插入有序
        map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        // write code here
        Integer value = map.get(key);
        if(value!=null){
            if(map.size()>1){
                map.remove(key);
                map.put(key,value); // 存入最后
            }
        }else{
            return -1;
        }
        return value;
    }

    public void put(int key, int value) {
        // write code here
        if(map.containsKey(key)){
            map.remove(key);
        }
        if(map.size()>=capacity){
            //这中相当于有一个指针，指向第一个数的前面 keySet() 返回key的集合
            //next() 取出下一个数，指针指向下一位
            Integer firstKey = map.keySet().iterator().next();
            map.remove(firstKey);
        }
        map.put(key,value);
    }
    public static void main(String[] args){
        LRUCache2 cache = new LRUCache2(2);
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
