package com.algorithm.set;

import java.util.ArrayList;

/**
 * @author JellyfishMIX
 * @date 2020/6/23 9:26 上午
 */
public class Main {
    public static void main(String[] args) {
        // binarySearchTreeSet
        System.out.println();
        System.out.println("BinarySearchTreeSet");
        System.out.println();

        Set<String> BstSet1 = new BstSet<>();
        Main.testSet(BstSet1, "a-tale-of-two-cities.txt");

        System.out.println();

        Set<String> BstSet2 = new BstSet<>();
        Main.testSet(BstSet2, "pride-and-prejudice.txt");

        // linkedListSet
        System.out.println();
        System.out.println("LinkedListSet");
        System.out.println();

        Set<String> linkedListSet1 = new LinkedListSet<>();
        Main.testSet(linkedListSet1, "a-tale-of-two-cities.txt");

        System.out.println();

        Set<String> linkedListSet2 = new LinkedListSet<>();
        Main.testSet(linkedListSet2, "pride-and-prejudice.txt");
    }

    /**
     * 测试性能
     *
     * @param set set
     * @param filename filename
     */
    private static void testSet(Set<String> set, String filename) {
        // 开始时间
        long startTime = System.nanoTime();

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("src/com/algorithm/set/" + filename, words);
        System.out.println(filename);
        System.out.println("Total words: " + words.size());
        for (String word : words) {
            set.add(word);
        }
        System.out.println("Total different words: " + set.getSize());

        long endTime = System.nanoTime();
        System.out.println(String.format("Consumed time: %f s", (endTime - startTime) / 1000000000.0));
    }
}
