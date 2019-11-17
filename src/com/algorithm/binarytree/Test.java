package com.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(1);
        BinaryTree.Node node2 = integerBinaryTree.addNode(integerBinaryTree.getRoot(), 2, true);
        BinaryTree.Node node3 = integerBinaryTree.addNode(integerBinaryTree.getRoot(), 3, false);
        BinaryTree.Node node4 = integerBinaryTree.addNode(node2, 4, true);
        BinaryTree.Node node5 = integerBinaryTree.addNode(node2, 5, false);
        BinaryTree.Node node6 = integerBinaryTree.addNode(node3, 6, true);
        BinaryTree.Node node7 = integerBinaryTree.addNode(node3, 7, false);

        List<BinaryTree<Integer>.Node> preOrderTraverseList;
        // 前序遍历
        preOrderTraverseList = integerBinaryTree.preOrder();
        System.out.println("前序遍历的结果为：");
        for (BinaryTree.Node myNode:preOrderTraverseList) {
            System.out.print(myNode.data);
        }
        System.out.println();

        List<BinaryTree<Integer>.Node> inOrderTraverseList;
        // 中序遍历
        inOrderTraverseList = integerBinaryTree.inOrder();
        System.out.println("中序遍历的结果为：");
        for (BinaryTree.Node myNode:inOrderTraverseList) {
            System.out.print(myNode.data);
        }
        System.out.println();

        List<BinaryTree<Integer>.Node> postOrderTraverseList;
        // 后序遍历
        postOrderTraverseList = integerBinaryTree.postOrder();
        System.out.println("后序遍历的结果为：");
        for (BinaryTree.Node myNode:postOrderTraverseList) {
            System.out.print(myNode.data);
        }
        System.out.println();
    }
}
