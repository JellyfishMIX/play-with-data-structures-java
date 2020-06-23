package com.algorithm.set;

/**
 * @author JellyfishMIX
 * @date 2020/6/23 8:09 上午
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
