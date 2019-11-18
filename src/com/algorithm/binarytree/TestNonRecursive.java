package com.algorithm.binarytree;

import java.util.List;

public class TestNonRecursive {
    /**
     * 非递归写法
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(1);
        BinaryTree.Node node2 = integerBinaryTree.addNode(integerBinaryTree.getRoot(), 2, true);
        BinaryTree.Node node3 = integerBinaryTree.addNode(integerBinaryTree.getRoot(), 3, false);
        BinaryTree.Node node4 = integerBinaryTree.addNode(node2, 4, true);
        BinaryTree.Node node5 = integerBinaryTree.addNode(node2, 5, false);
        BinaryTree.Node node6 = integerBinaryTree.addNode(node3, 6, true);
        BinaryTree.Node node7 = integerBinaryTree.addNode(node3, 7, false);
        BinaryTree.Node node8 = integerBinaryTree.addNode(node4, 8, true);
        BinaryTree.Node node9 = integerBinaryTree.addNode(node4, 9, false);
        BinaryTree.Node node10 = integerBinaryTree.addNode(node5, 10, true);
        BinaryTree.Node node11 = integerBinaryTree.addNode(node5, 11, false);
        BinaryTree.Node node12 = integerBinaryTree.addNode(node6, 12, true);
        BinaryTree.Node node13 = integerBinaryTree.addNode(node6, 13, false);
        BinaryTree.Node node14 = integerBinaryTree.addNode(node7, 14, true);
        BinaryTree.Node node15 = integerBinaryTree.addNode(node7, 15, false);

        // 前序遍历
        List<BinaryTree<Integer>.Node> preOrderTraversalList;
        preOrderTraversalList = integerBinaryTree.preOrderNonRecursive();
        System.out.println("前序遍历的结果为：");
        for (int i=0; i< preOrderTraversalList.size(); i++) {
            System.out.print(preOrderTraversalList.get(i).data);
            if (i != preOrderTraversalList.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // 中序遍历
        List<BinaryTree<Integer>.Node> inOrderTraversalList;
        inOrderTraversalList = integerBinaryTree.inOrderNonRecursive();
        System.out.println("中序遍历的结果为：");
        for (int i=0; i< inOrderTraversalList.size(); i++) {
            System.out.print(inOrderTraversalList.get(i).data);
            if (i != inOrderTraversalList.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // 后序遍历
        List<BinaryTree<Integer>.Node> postOrderTraversalList;
        postOrderTraversalList = integerBinaryTree.postOrderNonRecursive();
        System.out.println("后序遍历的结果为：");
        for (int i=0; i< postOrderTraversalList.size(); i++) {
            System.out.print(postOrderTraversalList.get(i).data);
            if (i != postOrderTraversalList.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
