package com.algorithm.heap;

import java.util.Arrays;
import java.util.Random;

/**
 * @author JellyfishMIX
 * @date 2020/9/22 15:47
 */
public class Main {
    public static void main(String[] args) {
        // 生成10个随机数add进MaxHeap中
        int n = 10;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        // 从堆首将堆中所存数据都取出，查看是否符合最大堆的性质
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        // 输出取出的数组
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("The order of the elements in MaxHeap is wrong.");
            }
        }
    }
}
