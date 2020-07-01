package com.algorithm.map;

import com.algorithm.set.FileOperation;

import java.util.ArrayList;

/**
 * @author JellyfishMIX
 * @date 2020/6/30 21:16
 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("LinkedListMap");
        System.out.println();
        Map<String, Integer> linkedListMap = new LinkedListMap<>();
        Main.testMap("pride-and-prejudice.txt", linkedListMap);

        System.out.println();
        System.out.println("LinkedListMap");
        System.out.println();
        Map<String, Integer> bstMap = new BstMap<>();
        Main.testMap("pride-and-prejudice.txt", bstMap);
    }

    private static void testMap(String filename, Map<String, Integer> map) {
        long startTime = System.nanoTime();

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("src/com/algorithm/set/" + filename, words);
        for (String word : words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("Frequency of PRIDE: " + map.get("pride"));
        System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

        long endTime = System.nanoTime();
        System.out.println(String.format("consumed time: %f %s", (endTime - startTime) / 1000000000.0, "s"));
    }
}
