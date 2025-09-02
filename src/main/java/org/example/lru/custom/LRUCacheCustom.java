package org.example.lru.custom;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU（Least Recently Used，最近最少使用)算法
 * <p>
 * 方式二：手搓双向链表 + 哈希表自定义实现
 *
 * @author puying
 * @date 2025/07/28
 */
public class LRUCacheCustom<K, V> {
    /**
     * 大小
     */
    private int size;

    /**
     * 容量
     */
    private final int capacity;

    /**
     * 头节点标识, 仅初始化
     */
    private final DoubleLinkedNode<K, V> head;

    /**
     * 尾节点标识, 仅初始化
     */
    private final DoubleLinkedNode<K, V> tail;

    /**
     * 哈希表, 缓存数据
     */
    public final Map<K, DoubleLinkedNode<K, V>> cache;


    public LRUCacheCustom(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DoubleLinkedNode<>();
        this.tail = new DoubleLinkedNode<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }


    /**
     * 获取指定值
     *
     * @param key 键
     * @return {@link V }
     */
    public V get(K key) {
        // 获取元素
        DoubleLinkedNode<K, V> node = cache.get(key);

        if (node == null) {
            throw new NullPointerException("node is null");
        }

        // 对访问过的元素移动至尾节点
        moveToTail(node);

        return node.value;
    }

    /**
     * 打印链表顺序
     */
    public void printLinkedList() {
        System.out.print("链表顺序: ");
        DoubleLinkedNode<K, V> current = head.next;
        boolean first = true;

        while (current != tail) {
            if (!first) {
                System.out.print(" -> ");
            }
            System.out.print("(" + current.key + ":" + current.value + ")");
            current = current.next;
            first = false;
        }
        System.out.println();
    }

    /**
     * 添加指定键值对
     *
     * @param key   键
     * @param value 值
     */
    public void put(K key, V value) {
        DoubleLinkedNode<K, V> node = cache.get(key);

        if (node == null) {
            // 创建新节点
            node = new DoubleLinkedNode<>(key, value);
            // 加入缓存
            cache.put(key, node);
            // 链表长度加1
            size++;
            // 移动至尾节点
            moveToTail(node);
            // 判断是否超过最大容量
            if (size > capacity) {
                // 删除头结点
                DoubleLinkedNode<K, V> headNode = removeHead();
                // 清除缓存
                cache.remove(headNode.key);
                // 链表长度减1
                size--;
            }
        } else {
            // 重写key的映射值
            node.value = value;
            // 移动到尾节点
            moveToTail(node);
        }
    }

    /**
     * 移动到尾结点
     *
     * @param node 节点
     */
    private void moveToTail(DoubleLinkedNode<K, V> node) {
        // 先清除当前节点位置
        removeNode(node);

        // 再添加当前节点至尾部
        addToTail(node);

    }

    /**
     * 删除结点
     *
     * @param node 节点
     */
    private void removeNode(DoubleLinkedNode<K, V> node) {
        if (node.next == null || node.prev == null) {
            return;
        }

        // 链接当前节点的前后节点
        // 将当前节点的下一个节点指向当前节点的上一个节点
        node.next.prev = node.prev;
        // 将当前节点的上一个节点指向当前节点的下一个节点
        node.prev.next = node.next;

        // 清除当前节点的指向
        node.next = null;
        node.prev = null;
    }

    /**
     * 添加到尾结点
     *
     * @param node 节点
     */
    private void addToTail(DoubleLinkedNode<K, V> node) {
        // 先链接当前节点的前后节点
        // 当前节点的上一个节点指向尾节点的上一个节点
        node.prev = tail.prev;
        // 当前节点的下一个节点指向尾节点
        node.next = tail;

        // 再链接前节点的后节点以及尾节点的前节点
        // 尾节点的上一个节点的下一个节点指向当前节点
        tail.prev.next = node;
        // 尾节点的上一个节点指向当前节点
        tail.prev = node;
    }

    /**
     * 删除头节点
     */
    private DoubleLinkedNode<K, V> removeHead() {
        DoubleLinkedNode<K, V> headNode = this.head.next;
        removeNode(headNode);
        return headNode;
    }
}
