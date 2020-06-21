package com.algorithm.binarysearchtree;

import java.util.*;

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

    // 递归

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

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
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
    public void postOrder() {
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

    // 非递归

    /**
     * 二分搜索树的前序遍历，非递归
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node popNode = stack.pop();
            System.out.println(popNode.e);
            if (popNode.right != null) {
                stack.push(popNode.right);
            }
            if (popNode.left != null) {
                stack.push(popNode.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历，非递归
     */
    public void inOrderNR() {
        Stack<Node> stack = new Stack<>();
        List<Node> nodeList = new ArrayList<>();
        Node popNode = this.root;
        while (popNode != null || !stack.isEmpty()) {
            while (popNode != null) {
                stack.push(popNode);
                popNode = popNode.left;
            }
            popNode = stack.pop();
            nodeList.add(popNode);
            popNode = popNode.right;
        }

        for (Node node : nodeList) {
            System.out.println(node.e);
        }
    }

    /**
     * 二分搜索树的后序遍历，非递归
     * 采用类似先序遍历的办法。先遍历根结点再右孩子最后左孩子(先序遍历是先遍历根节点再左孩子最后右孩子)，最后把遍历得到的序列逆转，即得到了后序遍历。
     */
    public void postOrderNR() {
        List<Node> nodeList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node popNode = stack.pop();
            nodeList.add(popNode);
            if (popNode.left != null) {
                stack.push(popNode.left);
            }
            if (popNode.right != null) {
                stack.push(popNode.right);
            }
        }

        Collections.reverse(nodeList);
        for (Node node : nodeList) {
            System.out.println(node.e);
        }
    }

    // 层次优先遍历（BFS）

    public void levelOrder() {
        List<Node> nodeList = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(this.root);
        while (!nodeQueue.isEmpty()) {
            Node pollNode = nodeQueue.poll();
            nodeList.add(pollNode);
            if (pollNode.left != null) {
                nodeQueue.add(pollNode.left);
            }
            if (pollNode.right != null) {
                nodeQueue.add(pollNode.right);
            }
        }

        for (Node node : nodeList) {
            System.out.println(node.e);
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if (this.size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is empty!");
        }

        return this.minimum(this.root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return this.minimum(node.left);
        }
    }

    // 寻找二分搜索树的最小元素，非递归
    public E minimumNR() {
        if (this.size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is empty!");
        }

        Node currentNode = this.root;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.e;
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if (this.size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is empty!");
        }

        return this.maximum(this.root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return this.maximum(node.right);
        }
    }

    // 寻找二分搜索树的最大元素，非递归
    public E maximumNR() {
        if (this.size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is empty!");
        }

        Node currentNode = this.root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode.e;
    }

    // 从二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin() {
        E minimum = this.minimum();
        this.removeMin(root);
        return minimum;
    }

    // 删除以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    public Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            this.size--;
            return rightNode;
        }

        node.left = this.removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点，返回最大值
    public E removeMax() {
        E maximum = this.maximum();
        this.removeMax(root);
        return maximum;
    }

    // 删除以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    public Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            this.size--;
            return leftNode;
        }

        node.right = this.removeMax(node.right);
        return node;
    }

    // 描述二叉树

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        this.generateBinarySearchTree(root, 0, res);
        return res.toString();
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
