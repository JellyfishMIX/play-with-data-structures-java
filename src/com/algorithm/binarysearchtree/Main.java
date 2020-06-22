package com.algorithm.binarysearchtree;

import java.util.ArrayList;
import java.util.Random;

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

        /////////////////
        //      5      //
        //     / \     //
        //    3   6    //
        //   / \   \   //
        //  2   4   8  //
        /////////////////

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

        // 删除最小元素的节点
        BinarySearchTree<Integer> binarySearchTreeForRemove = new BinarySearchTree<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            binarySearchTreeForRemove.add(random.nextInt(10000));
        }
        ArrayList<Integer> minimumArray = new ArrayList<>();
        while (!binarySearchTreeForRemove.isEmpty()) {
            minimumArray.add(binarySearchTreeForRemove.removeMin());
        }
        for (int i = 1; i < minimumArray.size(); i++) {
            if (minimumArray.get(i - 1) > minimumArray.get(i)) {
                throw new IllegalArgumentException("minimumArray Error");
            }
        }

        // 删除最大元素的节点
        for (int i = 0; i < 1000; i++) {
            binarySearchTreeForRemove.add(random.nextInt(10000));
        }
        ArrayList<Integer> maximumArray = new ArrayList<>();
        while (!binarySearchTreeForRemove.isEmpty()) {
            maximumArray.add(binarySearchTreeForRemove.removeMax());
        }
        for (int i = 1; i < maximumArray.size(); i++) {
            if (maximumArray.get(i - 1) < maximumArray.get(i)) {
                throw new IllegalArgumentException("maximumArray Error");
            }
        }

        // 删除元素3
        binarySearchTree.remove(3);

        // 描述二叉树

        System.out.println("Binary Search Tree Description(preOrder): ");
        System.out.println(binarySearchTree);
        System.out.println();
    }
}
