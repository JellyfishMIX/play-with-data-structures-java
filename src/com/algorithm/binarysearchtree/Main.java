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
        // binarySearchTree.preOrder();
        System.out.println(binarySearchTree);
    }
}
