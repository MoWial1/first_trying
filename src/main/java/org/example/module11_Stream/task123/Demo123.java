package org.example.module11_Stream.task123;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Demo123 {
    public static void main(String[] args) {
        String[] str = {"Ivan", "Timur", "Victor", "Vadim", "Miha", "Masha"};
        System.out.println(oddIndexes(str));

        System.out.println(Arrays.toString(toUpperCaseAndSort(str)));

        String[] array = {"1, 2, 0", "4, 5"};
        sortStrArrToString(array);
    }

    // task1
    public static String oddIndexes(String[] names) {
        return IntStream.range(0, names.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + Arrays.stream(names).toList().get(i))
                .collect(Collectors.joining(", "));
//        return Arrays.stream(names)
//                .map(name -> (Arrays.stream(names).toList().indexOf(name) + 1) + ". " + name)
//                .filter(name -> (Arrays.stream(names).toList().indexOf(name) % 2) != 0)
//                .collect(Collectors.joining(", "));
    }

    // task2
    public static String[] toUpperCaseAndSort(String[] lines) {
        return Arrays.stream(lines)
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toArray(String[]::new);
    }

    public static String sortStrArrToString(String[] array) {
        return Arrays.stream(array)
                .flatMap(str -> Arrays.stream(str.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
