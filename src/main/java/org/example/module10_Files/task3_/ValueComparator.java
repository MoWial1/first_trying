package org.example.module10_Files.task3_;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class ValueComparator implements Comparator<String> {
    private final Map<String, Integer> baseMap;

    public ValueComparator(Map<String, Integer> baseMap) {
        this.baseMap = baseMap;
    }

    @Override
    public int compare(String key1, String key2) {
        Integer value1 = baseMap.get(key1);
        Integer value2 = baseMap.get(key2);

        int compareValue = Integer.compare(value2, value1);

        if (compareValue == 0) {
            int first = Objects.hash(key1, value1);
            int second = Objects.hash(key2, value2);

            return Integer.compare(first, second);
        }

        return compareValue;
    }
}
