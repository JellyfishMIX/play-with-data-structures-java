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
}
