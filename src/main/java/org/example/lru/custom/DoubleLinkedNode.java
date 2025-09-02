package org.example.lru.custom;

import lombok.Data;

/**
 * 双向链表节点
 *
 * @author puying
 * @date 2025/07/28
 */
@Data
public class DoubleLinkedNode<K, V> {
    /**
     * 键
     */
    public K key;

    /**
     * 值
     */
    public V value;

    /**
     * 上一个节点
     */
    public DoubleLinkedNode<K, V> prev;

    /**
     * 下一个节点
     */
    public DoubleLinkedNode<K, V> next;

    public DoubleLinkedNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public DoubleLinkedNode() {

    }

    /**
     * 重写toString方法，避免节点间循环引用
     *
     * @return {@link String }
     */
    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "value=" + value +
                ", key=" + key +
                '}';
    }
}
