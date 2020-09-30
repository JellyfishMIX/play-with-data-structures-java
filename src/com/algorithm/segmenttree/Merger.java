package com.algorithm.segmenttree;

/**
 * @author JellyfishMIX
 * @date 2020/9/30 08:35
 */
public interface Merger<E> {
    E merge(E a, E b);
}
