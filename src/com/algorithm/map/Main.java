package com.algorithm.map;

import com.algorithm.set.FileOperation;

import java.util.ArrayList;

/**
 * @author JellyfishMIX
 * @date 2020/6/30 21:16
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        Map<String, Integer> map = new LinkedListMap<>();
        FileOperation.readFile("src/com/algorithm/set/pride-and-prejudice.txt", words);
        for (String word : words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("Frequency of PRIDE: " + map.get("pride"));
        System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
    }
}
