package com.algorithm.huffmantree;

import java.util.*;

public class HuffmanTree {
    public static class Node<E> {
        E data;
        int weight;
        Node left;
        Node right;

        public Node(E data, int weight) {
            super();
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node[data = " + this.data + ", weight = " + this.weight + "]";
        }
    }

    public Node createHuffmanTree(List<Node> nodeList) {
        // 如果nodeList中有两个及以上的Node，就循环
        while (nodeList.size() > 1) {
            // nodeList根据weight降序排列
            nodeList.sort(new Comparator<Node>() {
                public int compare(Node node1, Node node2) {
                    if (node1.weight > node2.weight) {
                        return node2.weight - node1.weight;
                    } else {
                        return node2.weight - node1.weight;
                    }
                }
            });

            // 获取权值最小的两个Node
            Node left = nodeList.get(nodeList.size() - 1);
            Node right = nodeList.get(nodeList.size() - 2);

            // 生成新Node，新Node的权值为两个子Node的权值之和
            Node parent = new Node(null, left.weight + right.weight);

            // 让新Node作为两个最小权值Node的父Node
            parent.left = left;
            parent.right = right;

            // 从nodeList中删除权值最小的两个Node
            nodeList.remove(nodeList.size() - 1);
            nodeList.remove(nodeList.size() - 1);

            // 组合出的新Node加入nodeList
            nodeList.add(parent);
        }
        return nodeList.get(0); // 返回根Node
    }

    public List<Node> breadthFirstTraversal(Node root) {
        Queue<Node> nodeQueue = new ArrayDeque<>();
        List<Node> nodeList = new ArrayList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            // 将队尾元素增加到nodeList中
            nodeList.add(nodeQueue.peek());
            Node parent = nodeQueue.poll();

            if (parent.left != null) {
                nodeQueue.add(parent.left);
            }
            if (parent.right != null) {
                nodeQueue.add(parent.right);
            }
        }
        return nodeList;
    }
}
