package com.algorithm.segmenttree;

/**
 * @author JellyfishMIX
 * @date 2020/9/28 14:01
 */
public class SegmentTree<E> {
    /**
     * Inside the SegmentTree, organize the data into a tree form. Use an array to represent this tree.
     * The SegmentTree is regarded as a full binary tree, and the deepest non-existent nodes are regarded as empty.
     * length: 4n
     */
    private E[] tree;
    /**
     * store a copy of the entire array in the SegmentTree
     * length: n
     */
    private E[] data;
    public SegmentTree(E[] arr) {
        data = arr;
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)  {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    /**
     * Returns the index of the left child node of an element represented by an index in the array representation of the complete binary tree.
     *
     * @param index index
     * @return
     */
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * Returns the index of the right child node of an element represented by an index in the array representation of the complete binary tree.
     *
     * @param index index
     * @return
     */
    public int rightChild(int index) {
        return 2 * index + 2;
    }
}
