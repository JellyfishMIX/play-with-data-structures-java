package com.algorithm.heap;

import com.algorithm.array.Array;

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
     * 返回完全二叉树中的数组表示中，索引i所表示的元素的父结点元素的索引
     *
     * @param index index
     * @return 父结点元素的index
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子结点的索引
     *
     * @param index 指定的index
     * @return 左孩子结点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子结点的索引
     *
     * @param index 指定的index
     * @return 右孩子结点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e 元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮操作。子结点循环地和父结点进行比较以保持最大二叉堆的性质。
     *
     * @param k 指定的索引
     */
    public void siftUp(int k) {
        if (k <= 0) {
            return;
        }
        // 和父结点做比较
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            int parentIndex = parent(k);
            data.swap(k, parentIndex);
            k = parentIndex;
        }
    }

    /**
     * 查找堆中的最大元素
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大的元素
     * @return
     */
    public E extractMax() {
        E res = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return res;
    }

    /**
     * 下沉操作。父结点依次和左右孩子比较，与左右孩子中最大的那个进行替换。
     *
     * @param k 指定的索引（从哪个结点开始进行siftDown操作）
     */
    public void siftDown(int k) {
        // 如果数组越界，说明k没有左孩子，是叶子结点
        while (leftChild(k) < data.getSize()) {
            int leftIndex = leftChild(k);
            int rightIndex = leftIndex + 1;
            // maxChild是左右孩子中最大的那个
            int maxChild = leftIndex;
            if (rightIndex < data.getSize() && data.get(rightIndex).compareTo(data.get(leftIndex)) > 0) {
                maxChild = rightIndex;
            }
            // 判断父结点是否比孩子结点中最大的那个大
            if (data.get(k).compareTo(data.get(maxChild)) >= 0) {
                break;
            }
            // 如果父结点是否比孩子结点中最大的那个孩子小
            data.swap(k, maxChild);
            k = maxChild;
        }
    }
}
