package org.example.module10_Files.task3_;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeMap;

public class WordFrequencyCounter {

    public TreeMap<String, Integer> countWordFrequency(String filePath) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\\s+");

                for (String word : words) {
                    treeMap.put(word, treeMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return treeMap;
    }
}
