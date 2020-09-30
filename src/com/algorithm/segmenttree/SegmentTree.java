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
    /**
     * Defined by the user to define the relationship between the parent node and the child nodes in the segment tree.
     */
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = arr;
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    /**
     * At the treeIndex position, build a segment tree representing the interval [l, r]
     *
     * @param treeIndex the index of the node in the tree
     * @param l left boundary of the interval
     * @param r right boundary of the interval
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // prevent overflow
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                stringBuilder.append(tree[i]);
            } else {
                stringBuilder.append("null");
            }
            if (i != tree.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
