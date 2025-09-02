package org.example.lru.custom;

public class LRUCustomTest {
    public static void main(String[] args) {
        LRUCacheCustom<Integer, String> lruCache = new LRUCacheCustom<>(3);
        lruCache.put(2, "美团");
        lruCache.put(3, "京东");
        lruCache.put(4, "淘宝");

        // 打印初始化链表信息
        lruCache.printLinkedList();

        // 访问一次元素，观察元素位置
        String value = lruCache.get(3);
        lruCache.printLinkedList();

        // 添加元素, 观察元素位置
        lruCache.put(1, "俄罗斯");
        lruCache.printLinkedList();
    }
}
