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
        System.out.println("binarySearchTreeSet");
        System.out.println();

        Set<String> BstSet1 = new BstSet<>();
        ArrayList<String> BstWords1 = new ArrayList<>();
        FileOperation.readFile("src/com/algorithm/set/a-tale-of-two-cities.txt", BstWords1);
        System.out.println("A tale of two cities");
        System.out.println("Total words: " + BstWords1.size());
        for (String word : BstWords1) {
            BstSet1.add(word);
        }
        System.out.println("Total different words: " + BstSet1.getSize());

        System.out.println();

        Set<String> BstSet2 = new BstSet<>();
        ArrayList<String> BstWords2 = new ArrayList<>();
        FileOperation.readFile("src/com/algorithm/set/pride-and-prejudice.txt", BstWords2);
        System.out.println("Pride and prejudice");
        System.out.println("Total words: " + BstWords2.size());
        for (String word : BstWords2) {
            BstSet2.add(word);
        }
        System.out.println("Total different words: " + BstSet2.getSize());

        // linkedListSet
        System.out.println();
        System.out.println("binarySearchTreeSet");
        System.out.println();

        Set<String> LinkedListSet1 = new LinkedListSet<>();
        ArrayList<String> LinkedListWords1 = new ArrayList<>();
        FileOperation.readFile("src/com/algorithm/set/a-tale-of-two-cities.txt", LinkedListWords1);
        System.out.println("A tale of two cities");
        System.out.println("Total words: " + LinkedListWords1.size());
        for (String word : LinkedListWords1) {
            LinkedListSet1.add(word);
        }
        System.out.println("Total different words: " + LinkedListSet1.getSize());

        System.out.println();

        Set<String> LinkedListSet2 = new LinkedListSet<>();
        ArrayList<String> LinkedListWords2 = new ArrayList<>();
        FileOperation.readFile("src/com/algorithm/set/pride-and-prejudice.txt", LinkedListWords2);
        System.out.println("Pride and prejudice");
        System.out.println("Total words: " + LinkedListWords2.size());
        for (String word : LinkedListWords2) {
            LinkedListSet2.add(word);
        }
        System.out.println("Total different words: " + LinkedListSet2.getSize());
    }
}
