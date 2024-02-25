package org.example.module10_Files.task3_;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.TreeMap;

public class Demo3 {
    private static final String filePath = "D:\\GoIT\\GoIT_Project\\src\\main\\java\\org\\example\\module10_Files\\task3_\\file.txt";
    public static void main(String[] args) {
        WordFrequencyCounter frequencyCounter = new WordFrequencyCounter();
        TreeMap<String, Integer> treeMap = frequencyCounter.countWordFrequency(filePath);

        TreeMap<String, Integer> sortedMapByValue = new TreeMap<>(new ValueComparator(treeMap));

        sortedMapByValue.putAll(treeMap);

        sortedMapByValue.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
