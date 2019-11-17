package com.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

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

    // 前序遍历
    public List<Node> preOrder() {
        return this.preOrderTraverse(this.root);
    }
    private List<Node> preOrderTraverse(Node myNode) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(myNode);
        if (myNode.leftNode != null) {
            nodeList.addAll(this.preOrderTraverse(myNode.leftNode));
        }
        if (myNode.rightNode != null) {
            nodeList.addAll((this.preOrderTraverse(myNode.rightNode)));
        }
        return nodeList;
    }

    // 中序遍历
    public List<Node> inOrder() {
        return this.inOrderTraverse(this.root);
    }
    private List<Node> inOrderTraverse(Node myNode) {
        List<Node> nodeList = new ArrayList<>();
        if (myNode.leftNode != null) {
            nodeList.addAll(this.inOrderTraverse(myNode.leftNode));
        }
        nodeList.add(myNode);
        if (myNode.rightNode != null) {
            nodeList.addAll((this.inOrderTraverse(myNode.rightNode)));
        }
        return nodeList;
    }

    // 后序遍历
    public List<Node> postOrder() {
        return this.postOrderTraverse(this.root);
    }
    private List<Node> postOrderTraverse(Node myNode) {
        List<Node> nodeList = new ArrayList<>();
        if (myNode.leftNode != null) {
            nodeList.addAll(this.postOrderTraverse(myNode.leftNode));
        }
        if (myNode.rightNode != null) {
            nodeList.addAll((this.postOrderTraverse(myNode.rightNode)));
        }
        nodeList.add(myNode);
        return nodeList;
    }
}
