package com.algorithm.heap;

/**
 * 一棵使用动态数组表示的最大堆，动态数组索引从0开始
 *
 * @author JellyfishMIX
 * @date 2020/7/3 23:18
 */
public class MaxHeap<E extends Comparable<E>> {
    // 使用动态数组表示一棵最大堆（完全二叉树）
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 返回堆中元素的个数
     *
     * @return 堆中元素的个数
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回一个boolean值，表示堆是否为空
     *
     * @return 表示堆是否为空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树中的数组表示中，索引i所表示的元素的父节点元素的索引
     *
     * @param index index
     * @return 父节点元素的index
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index 指定的index
     * @return 左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index 指定的index
     * @return 右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
