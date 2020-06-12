package com.algorithm.binarysearchtree;

public class BinarySearchTree<E extends Comparable<E>>{
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;  // 根节点
    private int size;   // 二分搜索树节点步长

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新元素
     * @param e element
     */
    public void add(E e) {
        root = this.add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素E，递归
     * @param node node
     * @param e element
     * @return 新的节点
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = this.add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = this.add(node.right, e);
        }

        return node;
    }
}
