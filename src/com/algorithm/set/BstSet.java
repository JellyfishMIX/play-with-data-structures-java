package com.algorithm.set;

import com.algorithm.binarysearchtree.BinarySearchTree;

/**
 * @author JellyfishMIX
 * @date 2020/6/23 8:11 上午
 */
public class BstSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> bst;

    public BstSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

}
