package com.algorithm.binarysearchtree;

/**
 * @author JellyfishMIX
 * @date 2020/6/13 9:23 上午
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            binarySearchTree.add(num);
        }

        // 描述二叉树

        System.out.println("Binary Search Tree Description(preOrder): ");
        System.out.println(binarySearchTree);
        System.out.println();

        // 前序遍历

        System.out.println("preOrder(recursive): ");
        binarySearchTree.preOrder();
        System.out.println();

        System.out.println("preOrder(non-recursive): ");
        binarySearchTree.preOrderNR();
        System.out.println();

        // 中序遍历

        System.out.println("inOrder(recursive): ");
        binarySearchTree.inOrder();
        System.out.println();

        System.out.println("inOrder(non-recursive): ");
        binarySearchTree.inOrderNR();
        System.out.println();

        // 后续遍历

        System.out.println("postOrder(recursive): ");
        binarySearchTree.postOrder();
        System.out.println();

        System.out.println("postOrder(non-recursive): ");
        binarySearchTree.postOrderNR();
        System.out.println();

        // 层次遍历（BFS）
        System.out.println("BFS: ");
        binarySearchTree.levelOrder();
        System.out.println();
    }
}
