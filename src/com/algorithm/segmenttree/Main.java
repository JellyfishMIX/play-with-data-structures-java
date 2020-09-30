package com.algorithm.segmenttree;

/**
 * @author JellyfishMIX
 * @date 2020/9/30 08:52
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        // count the sum of the nodes of the segment tree
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);
    }
}
