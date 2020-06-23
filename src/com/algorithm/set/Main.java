package com.algorithm.set;

import java.util.ArrayList;

/**
 * @author JellyfishMIX
 * @date 2020/6/23 9:26 上午
 */
public class Main {
    public static void main(String[] args) {
        Set<String> set1 = new BstSet<>();
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("src/com/algorithm/set/a-tale-of-two-cities.txt", words1);
        System.out.println("A tale of two cities");
        System.out.println("Total words: " + words1.size());
        for (String word : words1) {
            set1.add(word);
        }
        System.out.println("Total different words: " + set1.getSize());

        System.out.println();

        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("src/com/algorithm/set/pride-and-prejudice.txt", words2);
        Set<String> set2 = new BstSet<>();
        System.out.println("Pride and prejudice");
        System.out.println("Total words: " + words2.size());
        for (String word : words2) {
            set2.add(word);
        }
        System.out.println("Total different words: " + set2.getSize());
    }
}
