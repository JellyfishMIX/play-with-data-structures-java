package com.algorithm.binarytree;

import java.util.*;

public class BinaryTree<E> {
    public class Node {
        public E data;
        public Node leftNode, rightNode;

        public Node(E data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    private Node root;  // 根节点
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTree(E data) {
        this.root = new Node(data);
    }

    public Node addNode(Node parentNode, E data, boolean isLeft) {
        if (parentNode == null) {
            throw new RuntimeException("父节点为空，无法添加子节点");
        }
        if (isLeft && parentNode.leftNode != null) {
            throw new RuntimeException("左子节点已存在，添加失败");
        }
        if (!isLeft && parentNode.rightNode != null) {
            throw new RuntimeException("右子节点已存在，添加失败");
        }
        Node newNode = new Node(data);
        if (isLeft) {
            parentNode.leftNode = newNode;
        } else {
            parentNode.rightNode = newNode;
        }
        return newNode;
    }

    // 递归写法

    // 前序遍历
    public List<Node> preOrder() {
        return this.preOrderTraversal(this.root);
    }
    private List<Node> preOrderTraversal(Node myNode) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(myNode);
        if (myNode.leftNode != null) {
            nodeList.addAll(this.preOrderTraversal(myNode.leftNode));
        }
        if (myNode.rightNode != null) {
            nodeList.addAll((this.preOrderTraversal(myNode.rightNode)));
        }
        return nodeList;
    }

    // 中序遍历
    public List<Node> inOrder() {
        return this.inOrderTraversal(this.root);
    }
    private List<Node> inOrderTraversal(Node myNode) {
        List<Node> nodeList = new ArrayList<>();
        if (myNode.leftNode != null) {
            nodeList.addAll(this.inOrderTraversal(myNode.leftNode));
        }
        nodeList.add(myNode);
        if (myNode.rightNode != null) {
            nodeList.addAll((this.inOrderTraversal(myNode.rightNode)));
        }
        return nodeList;
    }

    // 后序遍历
    public List<Node> postOrder() {
        return this.postOrderTraversal(this.root);
    }
    private List<Node> postOrderTraversal(Node myNode) {
        List<Node> nodeList = new ArrayList<>();
        if (myNode.leftNode != null) {
            nodeList.addAll(this.postOrderTraversal(myNode.leftNode));
        }
        if (myNode.rightNode != null) {
            nodeList.addAll((this.postOrderTraversal(myNode.rightNode)));
        }
        nodeList.add(myNode);
        return nodeList;
    }

    // 非递归写法

    // 前序遍历
    public List<Node> preOrderNonRecursive() {
        List<Node> nodeList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node myNode = this.root;
        while (myNode != null || !nodeStack.isEmpty()) {
            while (myNode != null) {
                nodeList.add(myNode);
                nodeStack.push(myNode);
                myNode = myNode.leftNode;
            }
            myNode = nodeStack.pop();
            myNode = myNode.rightNode;
        }
        return nodeList;
    }

    // 中序遍历
    public List<Node> inOrderNonRecursive() {
        List<Node> nodeList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node myNode = this.root;
        while (myNode != null || !nodeStack.isEmpty()) {
            while (myNode != null) {
                nodeStack.push(myNode);
                myNode = myNode.leftNode;
            }
            myNode = nodeStack.pop();
            nodeList.add(myNode);
            myNode = myNode.rightNode;
        }
        return nodeList;
    }

    // 后序遍历
    // 采用类似先序遍历的办法。先遍历根结点再右孩子最后左孩子(先序遍历是先遍历根节点再左孩子最后右孩子)，最后把遍历得到的序列逆转，即得到了后序遍历。
    public List<Node> postOrderNonRecursive() {
        List<Node> nodeList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node myNode = this.root;
        while (myNode != null || !nodeStack.isEmpty()) {
            while (myNode != null) {
                nodeList.add(myNode);
                nodeStack.push(myNode);
                myNode = myNode.rightNode;
            }
            myNode = nodeStack.pop();
            myNode = myNode.leftNode;
        }
        Collections.reverse(nodeList);
        return nodeList;
    }

    // 层次遍历（广度优先搜索遍历）
    public List<Node> levelTraversal() {
        List<Node> nodeList = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(this.root);
        while (!nodeQueue.isEmpty()) {
            Node myNode = nodeQueue.poll();
            nodeList.add(myNode);
            if (myNode.leftNode != null) {
                nodeQueue.add(myNode.leftNode);
            }
            if (myNode.rightNode != null) {
                nodeQueue.add(myNode.rightNode);
            }
        }
        return nodeList;
    }
}
