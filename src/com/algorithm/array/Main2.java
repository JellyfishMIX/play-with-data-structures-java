package com.algorithm.array;

import com.algorithm.heap.MaxHeap;

import java.util.Random;

/**
 * heapify算法测试
 *
 * @author JellyfishMIX
 * @date 2020/9/23 13:28
 */
public class Main2 {
    /**
     * 测试heapify消耗时间
     *
     * @param testData 测试的数据
     * @param isHeapify 是否使用heapify算法
     * @return 消耗时间
     */
    private static double comparedHeapify(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        // 判断是否使用heapify方法
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

        // 从堆首将堆中所存数据都取出，查看是否符合最大堆的性质
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("The order of the elements in MaxHeap is wrong.");
            }
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        // 生成1000000个随机数
        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = comparedHeapify(testData, false);
        System.out.println(String.format("Without heapify: %fs", time1));
        double time2 = comparedHeapify(testData, false);
        System.out.println(String.format("With heapify: %fs", time2));
    }
}
