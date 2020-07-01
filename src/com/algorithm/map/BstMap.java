package com.algorithm.map;

/**
 * @author JellyfishMIX
 * @date 2020/7/1 10:38
 */
public class BstMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public BstMap() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 添加元素
     *
     * @param key   key
     * @param value value
     */
    @Override
    public void add(K key, V value) {
        this.root = this.add(this.root, key, value);
    }

    /**
     * 向以node为根的二分搜索树中插入新节点
     *
     * @param node  node
     * @param key   key
     * @param value value
     * @return 插入新节点后的二分搜索树的根
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            this.size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = this.add(node.left, key, value);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = this.add(node.right, key, value);
            return node;
        } else {
            node.value = value;
            return node;
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
        Node result = this.remove(this.root, key);
        return result == null ? null : result.value;
    }

    /**
     * 删除以node为根的二分搜索树中key对应的节点
     *
     * @param node node
     * @param key  key
     * @return 删除操作后二分搜索树的根
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = this.remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = this.remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                node = node.right;
                this.size--;
                return node;
            } else if (node.right == null) {
                node = node.left;
                this.size--;
                return node;
            } else {
                // Hibbard Deletion
                Node successor = minimum(node.right);
                successor.left = node.left;
                successor.right = removeMin(node.right);
                return successor;
            }
        }
    }

    /**
     * key是否存在
     *
     * @param key key
     * @return true/false
     */
    @Override
    public boolean contains(K key) {
        return this.getNode(this.root, key) != null;
    }

    /**
     * 根据key获取value
     *
     * @param key key
     * @return key对应的value
     */
    @Override
    public V get(K key) {
        Node result = this.getNode(this.root, key);
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
        Node result = this.getNode(this.root, key);
        if (result == null) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }

        result.value = newValue;
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
     * 返回以node为根节点的二分搜索树中，key所在的节点
     *
     * @param node node
     * @param key  key
     * @return 以node为根节点的二分搜索树中，key所在的节点
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            return this.getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return this.getNode(node.right, key);
        } else {
            return node;
        }
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在节点
     *
     * @return 最小值所在节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return this.minimum(node.left);
        }
    }

    /**
     * 删除以node为根的二分搜索树的最小值所在节点
     *
     * @return 删除操作后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            node = node.right;
            this.size--;
            return node;
        }

        node.left = removeMin(node.left);
        return node;
    }
}