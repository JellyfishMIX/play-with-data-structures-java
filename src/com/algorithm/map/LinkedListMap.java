package com.algorithm.map;

/**
 * @author JellyfishMIX
 * @date 2020/6/30 20:10
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
            this.key = null;
            this.value = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * 头节点
     */
    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = this.getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            this.size++;
        } else {
            // update to newValue
            node.value = value;
        }
    }

    /**
     * 删除key对应的Node
     *
     * @param key key
     * @return key对应的value，如果key不存在，则返回null
     */
    @Override
    public V remove(K key) {
        Node prev = this.dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            } else {
                prev = prev.next;
            }
        }
        if (prev.next != null) {
            V delValue = prev.next.value;
            prev.next = prev.next.next;
            this.size--;
            return delValue;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        Node cursor = this.dummyHead.next;
        while (cursor != null) {
            if (cursor.key.equals(key)) {
                return true;
            } else {
                cursor = cursor.next;
            }
        }
        return false;
    }

    /**
     * 根据key获取value
     *
     * @param key key
     * @return key对应的value
     */
    @Override
    public V get(K key) {
        Node result = this.getNode(key);
        return result == null ? null : result.value;
    }

    /**
     * 把key值的value设置为newValue，如果Key不存在会报错
     *
     * @param key      key
     * @param newValue newValue
     */
    @Override
    public void set(K key, V newValue) {
        Node node = this.getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        } else {
            node.value = newValue;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 通过Key获取对应的Node
     *
     * @param key key
     * @return key对应的Node
     */
    private Node getNode(K key) {
        Node cursor = dummyHead.next;
        while (cursor != null) {
            if (cursor.key.equals(key)) {
                return cursor;
            } else {
                cursor = cursor.next;
            }
        }
        return null;
    }
}
