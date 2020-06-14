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

    /**
     * 查看二分搜索树中是否包含元素e
     * @param e element
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 查看以node为根的二分搜索树中是否包含元素e，递归
     * @param node node
     * @param e element
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return this.contains(node.left, e);
        } else {
            return this.contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归
     * @param node node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        this.generateBinarySearchTree(root, 0, res);
        return res.toString();
    }

    /**
     * 二分搜索树的中序遍历
     */
    private void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归
     * @param node node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        this.inOrder(node.left);
        System.out.println(node.e);
        this.inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    private void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归
     * @param node node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param node node
     * @param depth 深度
     * @param res 一个StringBuilder
     */
    private void generateBinarySearchTree(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(describeDepth(depth) + "null\n");
            return;
        }

        res.append(describeDepth(depth) + node.e + '\n');
        this.generateBinarySearchTree(node.left, depth + 1, res);
        this.generateBinarySearchTree(node.right, depth + 1, res);
    }

    /**
     * 描述深度
     * @param depth 二叉搜索树的深度
     */
    private String describeDepth(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("-");
        }
        return res.toString();
    }
}
